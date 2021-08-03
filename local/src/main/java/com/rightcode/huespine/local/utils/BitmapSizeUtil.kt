package com.rightcode.huespine.local.utils

import android.graphics.BitmapFactory
import java.io.InputStream

object BitmapSizeUtil {
    @JvmStatic
    fun getSizeWithKeepRatio(
        inputStream: InputStream,
        resizeWidthTo: Int
    ): Pair<Int, Int> {
        return BitmapFactory.Options().run {
            inJustDecodeBounds = true

            BitmapFactory.decodeStream(inputStream, null, this)

            val scale = resizeWidthTo.toDouble() / outWidth
            val resizeHeightTo = (outHeight * scale).toInt()
            resizeWidthTo to resizeHeightTo
        }
    }
}