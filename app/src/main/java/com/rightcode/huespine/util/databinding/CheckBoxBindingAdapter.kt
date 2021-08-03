package com.rightcode.huespine.util.databinding

import android.widget.CheckBox
import android.widget.CompoundButton
import androidx.databinding.BindingAdapter
import io.reactivex.subjects.Subject

@BindingAdapter("checkedChanges")
fun CheckBox.bindCheckedChanges(subject: Subject<Boolean>) {
    this.setOnCheckedChangeListener { _, isChecked ->
        subject.onNext(isChecked)
    }
}

@BindingAdapter("checkedChanges")
fun CheckBox.bindCheckedChanges(listener: CompoundButton.OnCheckedChangeListener) {
    this.setOnCheckedChangeListener(listener)
}