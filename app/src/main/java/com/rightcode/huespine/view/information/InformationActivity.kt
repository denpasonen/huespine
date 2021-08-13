package com.rightcode.huespine.view.information

import androidx.activity.viewModels
import androidx.lifecycle.LifecycleOwner
import com.rightcode.huespine.R
import com.rightcode.huespine.databinding.ActivityInformationBinding
import com.rightcode.huespine.view.base.ActivityLauncher
import com.rightcode.huespine.view.base.BaseActivity
import com.rightcode.huespine.view.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlin.reflect.KClass

@AndroidEntryPoint
class InformationActivity : BaseActivity<ActivityInformationBinding, InformationViewModelType>(
) {
    override val layoutResId: Int get() = R.layout.activity_information
    override val viewModel: InformationViewModelType by viewModels<InformationViewModel>()

    override fun onWillAttachViewModel(
        lifecycleOwner: LifecycleOwner,
        viewDataBinding: ActivityInformationBinding,
        viewModel: InformationViewModelType
    ) {
        super.onWillAttachViewModel(lifecycleOwner, viewDataBinding, viewModel)

        with(viewModel.output) {
//            showMain.observe {
//                MainActivity.startActivity(this@InformationActivity)
//                finish()
//            }
        }
    }

    companion object : ActivityLauncher<InformationActivity>() {
        override val activityClass: KClass<InformationActivity>
            get() = InformationActivity::class
    }
}