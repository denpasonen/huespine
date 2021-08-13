package com.rightcode.huespine.view.information

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.rightcode.huespine.domain.provider.SchedulerProvider
import com.rightcode.huespine.domain.service.BannerService
import com.rightcode.huespine.view.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.BackpressureStrategy
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class InformationViewModel @Inject constructor(
    stateHandle: SavedStateHandle,
    schedulerProvider: SchedulerProvider
) : BaseViewModel(stateHandle, schedulerProvider),
    InformationViewModelType, InformationViewModelType.Output, InformationViewModelType.Input {

    override val input: InformationViewModelType.Input = this
    override val output: InformationViewModelType.Output = this

    private val _onTimer: Subject<Unit> = PublishSubject.create()

    private val _showMain: MutableLiveData<Unit> = MutableLiveData()
    override val showMain: LiveData<Unit> = _showMain

    init {
        _onTimer
            .startWith(Unit)
            .delay(2, TimeUnit.SECONDS)
            .observeOn(schedulerProvider.ui)
            .subscribe(_showMain::setValue)
            .addDisposable()
    }
}