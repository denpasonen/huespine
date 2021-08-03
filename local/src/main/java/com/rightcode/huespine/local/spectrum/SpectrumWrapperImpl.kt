package com.rightcode.huespine.local.spectrum

import com.facebook.spectrum.EncodedImageSink
import com.facebook.spectrum.EncodedImageSource
import com.facebook.spectrum.Spectrum
import com.facebook.spectrum.image.EncodedImageFormat
import com.facebook.spectrum.image.ImageSize
import com.facebook.spectrum.options.TranscodeOptions
import com.facebook.spectrum.requirements.EncodeRequirement
import com.facebook.spectrum.requirements.ResizeRequirement
import com.facebook.spectrum.requirements.RotateRequirement
import com.rightcode.huespine.local.BuildConfig
import java.io.ByteArrayOutputStream
import java.io.InputStream
import javax.inject.Inject

internal class SpectrumWrapperImpl @Inject constructor(
    private val spectrum: Spectrum
) : SpectrumWrapper {
    override fun transcodeToJpeg(
        inputStream: InputStream,
        quality: Int,
        targetWidth: Int,
        targetHeight: Int
    ): ByteArray? {
        return ByteArrayOutputStream().use { outputStream ->
            val result = spectrum.transcode(
                EncodedImageSource.from(inputStream),
                EncodedImageSink.from(outputStream),
                TranscodeOptions.Builder(
                    EncodeRequirement(
                        EncodedImageFormat.JPEG,
                        quality,
                        EncodeRequirement.Mode.LOSSY
                    )
                )
                    .resize(
                        ResizeRequirement(
                            ResizeRequirement.Mode.EXACT_OR_LARGER,
                            ImageSize(targetWidth, targetHeight)
                        )
                    )
                    .rotate(RotateRequirement(true))
                    .build(),
                SPECTRUM_CONTEXT
            )

            if (result.isSuccessful) {
                outputStream.toByteArray()
            } else {
                null
            }
        }
    }

    companion object {
        private const val SPECTRUM_CONTEXT = BuildConfig.LIBRARY_PACKAGE_NAME + ".transcode"
    }
}