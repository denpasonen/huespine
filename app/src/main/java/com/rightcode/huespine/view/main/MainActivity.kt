package com.rightcode.huespine.view.main

import androidx.activity.viewModels
import androidx.lifecycle.LifecycleOwner
import com.rightcode.huespine.R
import com.rightcode.huespine.databinding.ActivityMainBinding
import com.rightcode.huespine.view.base.ActivityLauncher
import com.rightcode.huespine.view.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlin.reflect.KClass

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModelType>(
) {
    override val layoutResId: Int get() = R.layout.activity_main
    override val viewModel: MainViewModelType by viewModels<MainViewModel>()

    override fun onWillAttachViewModel(
        lifecycleOwner: LifecycleOwner,
        viewDataBinding: ActivityMainBinding,
        viewModel: MainViewModelType
    ) {
        super.onWillAttachViewModel(lifecycleOwner, viewDataBinding, viewModel)
    }

    companion object : ActivityLauncher<MainActivity>() {
        override val activityClass: KClass<MainActivity>
            get() = MainActivity::class
    }
}