package com.rightcode.huespine.util.databinding

import android.widget.TextView
import androidx.core.text.parseAsHtml
import androidx.databinding.BindingAdapter

@BindingAdapter("html")
fun TextView.bindHtml(html: String?) {
    text = html?.parseAsHtml()
}