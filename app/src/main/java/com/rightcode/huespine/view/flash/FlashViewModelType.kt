package com.rightcode.huespine.view.flash

import androidx.lifecycle.LiveData
import com.rightcode.huespine.view.base.ViewModelType

interface FlashViewModelType : ViewModelType<FlashViewModelType.Input, FlashViewModelType.Output> {
    interface Input : ViewModelType.Input {
    }

    interface Output : ViewModelType.Output {
        val showMain:LiveData<Unit>
    }
}