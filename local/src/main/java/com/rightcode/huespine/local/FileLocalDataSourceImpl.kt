package com.rightcode.huespine.local

import android.content.ContentResolver
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import com.rightcode.huespine.data.model.FileInfoData
import com.rightcode.huespine.data.source.local.FileLocalDataSource
import com.rightcode.huespine.local.spectrum.SpectrumWrapper
import com.rightcode.huespine.local.utils.BitmapSizeUtil
import com.rightcode.huespine.local.utils.rx.ext.mapToDataError
import com.rightcode.huespine.local.utils.rx.schedulers.SchedulerProvider
import io.reactivex.Single
import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import javax.inject.Inject

internal class FileLocalDataSourceImpl @Inject constructor(
    private val contentResolver: ContentResolver,
    private val spectrum: SpectrumWrapper,
    private val schedulerProvider: SchedulerProvider
) : FileLocalDataSource {

    override fun getCompressedJpeg(
        path: String
    ): Single<ByteArray> {
        return Single.create<ByteArray> { emitter ->
            val uriByPath = Uri.parse(path)
            getInputStream(uriByPath)?.use { bitmapStream ->
                //... Bitmap.decodeStream내부에서 inputStream을 close시켜버리니까 뒤에서 새로 생성하도록...
                val (width, height) = BitmapSizeUtil.getSizeWithKeepRatio(bitmapStream, 1_000)

                getInputStream(uriByPath)?.use { spectrumStream ->
                    val compressedImage =
                        spectrum.transcodeToJpeg(spectrumStream, 80, width, height)
                    if (compressedImage != null) {
                        if (!emitter.isDisposed) {
                            emitter.onSuccess(compressedImage)
                        }
                    } else {
                        emitter.onError(IllegalStateException("can not compress image: $path"))
                    }
                }
            }
        }.subscribeOn(schedulerProvider.io).mapToDataError()
    }

    override fun getFileInfo(path: String): Single<FileInfoData> {
        return Single.create<FileInfoData> { emitter ->
            val uriByPath = Uri.parse(path)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                contentResolver.query(
                    uriByPath,
                    arrayOf(MediaStore.Images.Media.DISPLAY_NAME),
                    null,
                    null,
                    null
                )?.use { cursor ->
                    if (cursor.moveToNext()) {
                        val name =
                            cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME))
                        if (!emitter.isDisposed) {
                            emitter.onSuccess(FileInfoData(path = path, name = name))
                        }
                    } else {
                        throw IllegalStateException("no file found")
                    }
                }
            } else {
                if (!emitter.isDisposed) {
                    emitter.onSuccess(FileInfoData(path = path, name = uriByPath.lastPathSegment!!))
                }
            }
        }.subscribeOn(schedulerProvider.io).mapToDataError()
    }

    private fun getInputStream(uri: Uri): InputStream? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            contentResolver.openInputStream(uri)
        } else {
            FileInputStream(File(uri.path!!))
        }
    }
}