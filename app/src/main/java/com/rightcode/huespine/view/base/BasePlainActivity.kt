package com.rightcode.huespine.view.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BasePlainActivity<VDB> :
    AppCompatActivity() where VDB : ViewDataBinding {
    @LayoutRes
    protected open val layoutResId: Int = 0
    protected lateinit var viewDataBinding: VDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView<VDB>(this, layoutResId).apply {
            lifecycleOwner = this@BasePlainActivity
        }
    }
}