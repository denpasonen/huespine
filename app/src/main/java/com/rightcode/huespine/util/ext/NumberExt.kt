package com.rightcode.huespine.util.ext

import android.content.res.Resources
import android.util.TypedValue

val Number.pxFromDp: Float
    get() {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this.toFloat(),
            Resources.getSystem().displayMetrics
        )
    }

val Number.positive: Boolean
    get() = this.toInt() >= 0

val Number.negative: Boolean
    get() = this.toInt() < 0
