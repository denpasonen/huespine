package com.rightcode.huespine.util.ext

import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("textColor")
fun TextView.bindVisibleOrInvisible(color: Int) {
    this.setTextColor(color)
}

@BindingAdapter(
    value = [
        "onSearchClick",
        "onSendClick",
        "onDoneClick"
    ], requireAll = false
)
fun TextView.bindEditorActions(
    onSearchClick: View.OnClickListener? = null,
    onSendClick: View.OnClickListener? = null,
    onDoneClick: View.OnClickListener? = null
) {
    this.setOnEditorActionListener { v, actionId, _ ->
        when (actionId) {
            EditorInfo.IME_ACTION_SEARCH -> {
                onSearchClick?.onClick(v)
                true
            }
            EditorInfo.IME_ACTION_SEND -> {
                onSendClick?.onClick(v)
                true
            }
            EditorInfo.IME_ACTION_DONE -> {
                onDoneClick?.onClick(v)
                true
            }
            else -> {
                false
            }
        }
    }
}
