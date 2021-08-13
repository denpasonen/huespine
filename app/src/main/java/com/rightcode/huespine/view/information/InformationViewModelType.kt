package com.rightcode.huespine.view.information

import androidx.lifecycle.LiveData
import com.rightcode.huespine.view.base.ViewModelType

interface InformationViewModelType : ViewModelType<InformationViewModelType.Input, InformationViewModelType.Output> {
    interface Input : ViewModelType.Input {
    }

    interface Output : ViewModelType.Output {
        val showMain:LiveData<Unit>
    }
}