package com.rightcode.huespine.util.databinding

import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import androidx.databinding.BindingAdapter
import com.rightcode.huespine.util.databinding.listener.OnItemSelectedListener
import com.rightcode.huespine.view.base.BaseArrayAdapter

@Suppress("UNCHECKED_CAST")
@BindingAdapter("list")
fun <T> Spinner.bindList(list: List<T>?) {
    (this.adapter as? BaseArrayAdapter<T>)?.submitList(list)
}

@BindingAdapter("selectedItem")
fun Spinner.bindSelectedItem(position: Int) {
    if (this.selectedItemPosition == position) return
    this.setSelection(position)
}

@BindingAdapter("selectedItemChanged")
fun Spinner.bindSelectedItemChanged(listener: OnItemSelectedListener) {
    this.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            listener.onItemSelected(position)
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {

        }
    }
}