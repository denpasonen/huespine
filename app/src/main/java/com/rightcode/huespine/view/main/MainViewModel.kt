package com.rightcode.huespine.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.rightcode.huespine.domain.provider.SchedulerProvider
import com.rightcode.huespine.domain.service.BannerService
import com.rightcode.huespine.util.ext.format
import com.rightcode.huespine.util.ext.ignoreTime
import com.rightcode.huespine.util.lifecycle.SingleLiveData
import com.rightcode.huespine.view.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    stateHandle: SavedStateHandle,
    schedulerProvider: SchedulerProvider,
    bannerService: BannerService
) : BaseViewModel(stateHandle, schedulerProvider),
    MainViewModelType, MainViewModelType.Output, MainViewModelType.Input {

    override val input: MainViewModelType.Input = this
    override val output: MainViewModelType.Output = this

    private val _isShowBanner: MutableLiveData<Boolean> = MutableLiveData()
    override val isShowBanner: LiveData<Boolean> = _isShowBanner

    private val _routeCalendar: MutableLiveData<Unit> = SingleLiveData()
    override val routeCalendar: LiveData<Unit> = _routeCalendar

    init {
        bannerService
            .getNotShowToday()
            .map {
                if (it.isEmpty()) {
                    _isShowBanner.postValue(true)
                } else {
                    val simpleFormat = DateTimeFormatter.ISO_DATE;
                    val beforeDate = LocalDate.parse(it, simpleFormat)
                    val today = Date().ignoreTime().format("yyyy-MM-dd")
                    if (LocalDate.parse(today, simpleFormat).isAfter(beforeDate)) {
                        _isShowBanner.postValue(true)
                    } else {
                        _isShowBanner.postValue(false)
                    }
                }
            }.subscribe()
            .addDisposable()
    }

    override fun routeCalendarTab() {
        _routeCalendar.value = Unit
    }
}