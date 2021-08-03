package com.rightcode.huespine.util.databinding

import android.view.View
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.databinding.BindingAdapter
import com.rightcode.huespine.util.databinding.listener.OnTextChangedListener

@BindingAdapter("onTextChanged")
fun EditText.bindTextChanged(listener: OnTextChangedListener?) {
    this.addTextChangedListener { editable ->
        listener?.onTextChanged(editable?.toString() ?: "")
    }
}

@BindingAdapter("onFocusChanged")
fun EditText.bindFocusChanged(listener: View.OnFocusChangeListener) {
    listener.onFocusChange(this, hasFocus())
    this.onFocusChangeListener = listener
}