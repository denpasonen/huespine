package com.rightcode.huespine.view.flash

import androidx.activity.viewModels
import androidx.lifecycle.LifecycleOwner
import com.rightcode.huespine.R
import com.rightcode.huespine.databinding.ActivityFlashBinding
import com.rightcode.huespine.view.base.ActivityLauncher
import com.rightcode.huespine.view.base.BaseActivity
import com.rightcode.huespine.view.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlin.reflect.KClass

@AndroidEntryPoint
class FlashActivity : BaseActivity<ActivityFlashBinding, FlashViewModelType>(
) {
    override val layoutResId: Int get() = R.layout.activity_flash
    override val viewModel: FlashViewModelType by viewModels<FlashViewModel>()

    override fun onWillAttachViewModel(
        lifecycleOwner: LifecycleOwner,
        viewDataBinding: ActivityFlashBinding,
        viewModel: FlashViewModelType
    ) {
        super.onWillAttachViewModel(lifecycleOwner, viewDataBinding, viewModel)

        with(viewModel.output) {
            showMain.observe {
                MainActivity.startActivity(this@FlashActivity)
                finish()
            }
        }
    }

    companion object : ActivityLauncher<FlashActivity>() {
        override val activityClass: KClass<FlashActivity>
            get() = FlashActivity::class
    }
}