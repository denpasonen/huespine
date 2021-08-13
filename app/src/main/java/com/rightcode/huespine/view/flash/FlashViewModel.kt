package com.rightcode.huespine.view.flash

import android.os.Handler
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.rightcode.huespine.domain.provider.SchedulerProvider
import com.rightcode.huespine.view.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Single
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import java.util.*
import javax.inject.Inject


@HiltViewModel
class FlashViewModel @Inject constructor(
    stateHandle: SavedStateHandle,
    schedulerProvider: SchedulerProvider
) : BaseViewModel(stateHandle, schedulerProvider),
    FlashViewModelType, FlashViewModelType.Output, FlashViewModelType.Input {

    override val input: FlashViewModelType.Input = this
    override val output: FlashViewModelType.Output = this

    private val _showMain: MutableLiveData<Unit> = MutableLiveData()
    override val showMain: LiveData<Unit> = _showMain

    init {
        Handler().postDelayed({
            Single.just(Unit).subscribe(_showMain::setValue)
        }, 3000L)
    }
}