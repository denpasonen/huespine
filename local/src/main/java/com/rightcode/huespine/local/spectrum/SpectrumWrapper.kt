package com.rightcode.huespine.local.spectrum

import java.io.InputStream

internal interface SpectrumWrapper {
    fun transcodeToJpeg(
        inputStream: InputStream,
        quality: Int,
        targetWidth: Int,
        targetHeight: Int
    ): ByteArray?
}