package com.rightcode.huespine.util.databinding

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("selected")
fun View.bindSelected(isSelected: Boolean) {
    this.isSelected = isSelected
}