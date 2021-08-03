package com.rightcode.huespine.util

import com.rightcode.huespine.BuildConfig
import com.rightcode.huespine.data.exception.KKException
import com.rightcode.huespine.domain.exception.InDevelopException

object ExceptionUtils {
    @JvmStatic
    fun toLocalized(error: Throwable): String {
        val originalMessage = error.toLocalizedInternal()
        return if (BuildConfig.FLAVOR == "dev") {
            "${originalMessage}\n\n개발자 전달용 메시지: ${error.stackTraceToString()}"
        } else
            originalMessage
    }

    private fun Throwable.toLocalizedInternal(): String {
        printStackTrace()
        when (this) {
            is KKException -> when (this.statusCode) {
                400 -> {
                    return "입력 내용을 다시 확인해주세요."
                }
                401 -> {
                    return "로그인이 만료되었습니다."
                }
                404 -> {
                    return "항목이 존재하지 않습니다."
                }
                in 500 until 600 -> {
                    return "서버 오류가 발생하였습니다."
                }
                else -> when (this.message) {

                }
            }

            is InDevelopException -> {
                return "개발중입니다."
            }
        }
        return "오류가 발생하였습니다."
    }
}

