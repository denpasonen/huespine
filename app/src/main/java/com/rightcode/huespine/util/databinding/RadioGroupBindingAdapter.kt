package com.rightcode.huespine.util.databinding

import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.view.children
import androidx.databinding.BindingAdapter
import com.rightcode.huespine.util.databinding.listener.OnRadioButtonChangedListener

@BindingAdapter("onCheckedChange")
fun <T> RadioGroup.bindCheckedChange(listener: OnRadioButtonChangedListener) {
    this.setOnCheckedChangeListener { radioGroup, checkedId ->
        val checkedView = radioGroup.findViewById<RadioButton>(checkedId)
            ?: return@setOnCheckedChangeListener
        listener.onRadioButtonChanged(checkedView.tag as T)
    }
}

@BindingAdapter("checkedButton")
fun <T> RadioGroup.bindCheckedButton(newValue: T?) {
    if (newValue == null) this.clearCheck()
    else this.children.filter {
        it is RadioButton && it.tag == newValue
    }.forEach {
        check(it.id)
    }
}



