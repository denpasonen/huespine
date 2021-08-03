package com.rightcode.huespine.util.databinding

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.CircleCropTransformation
import java.io.File

@BindingAdapter(
    value = ["src", "placeholder", "isCircleCrop", "isCrossFade"], requireAll = false
)
fun ImageView.bindUrl(
    url: String?,
    placeholder: Drawable?,
    isCircleCrop: Boolean = false,
    isCrossFade: Boolean = false
) {
    url?.let {
        this.load(it) {
            error(placeholder)
            placeholder(placeholder)
            crossfade(isCrossFade)
            if (isCircleCrop) transformations(CircleCropTransformation())
        }
    }
}

@BindingAdapter(
    value = ["src", "placeholder", "isCircleCrop", "isCrossFade"], requireAll = false
)
fun ImageView.bindResource(
    drawable: Drawable?,
    placeholder: Drawable?,
    isCircleCrop: Boolean = false,
    isCrossFade: Boolean = false
) {
    drawable?.let {
        this.load(it) {
            error(placeholder)
            placeholder(placeholder)
            crossfade(isCrossFade)
            if (isCircleCrop) transformations(CircleCropTransformation())
        }
    }
}

@BindingAdapter("src")
fun ImageView.bindFile(file: File?) {
    file?.let {
        this.load(it)
    }
}

