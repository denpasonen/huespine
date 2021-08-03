package com.rightcode.huespine.view.main

import androidx.lifecycle.LiveData
import com.rightcode.huespine.view.base.ViewModelType

interface MainViewModelType : ViewModelType<MainViewModelType.Input, MainViewModelType.Output> {
    interface Input : ViewModelType.Input {
        fun routeCalendarTab()
    }

    interface Output : ViewModelType.Output {
        val isShowBanner: LiveData<Boolean>
        val routeCalendar: LiveData<Unit>
    }
}