package com.rightcode.huespine.view.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.rightcode.huespine.domain.provider.SchedulerProvider
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.addTo

abstract class BaseViewModel(
    protected val stateHandle: SavedStateHandle,
    private val schedulerProvider: SchedulerProvider
) : ViewModel() {
    protected val compositeDisposable: CompositeDisposable by lazy(::CompositeDisposable)

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

    protected fun <T> Observable<T>.bind(to: MutableLiveData<T>) {
        this.observeOn(schedulerProvider.ui)
            .subscribe(to::setValue)
            .addTo(compositeDisposable)
    }

    protected fun Disposable.addDisposable() {
        compositeDisposable.add(this)
    }
}