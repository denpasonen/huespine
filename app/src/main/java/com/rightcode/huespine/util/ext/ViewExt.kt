package com.rightcode.huespine.util.ext

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("visibleOrGone")
fun View.bindVisibleOrGone(isVisible: Boolean) {
    this.visibility = if (isVisible) View.VISIBLE else View.GONE
}

@BindingAdapter("visibleOrInvisible")
fun View.bindVisibleOrInvisible(isVisible: Boolean) {
    this.visibility = if (isVisible) View.VISIBLE else View.INVISIBLE
}
