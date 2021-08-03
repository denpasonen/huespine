package com.rightcode.huespine.local

import com.rightcode.huespine.data.source.local.SearchLocalDataSource
import com.rightcode.huespine.local.preferences.SearchPref
import com.rightcode.huespine.local.utils.rx.ext.mapToDataError
import com.rightcode.huespine.local.utils.rx.schedulers.SchedulerProvider
import io.reactivex.Completable
import io.reactivex.internal.operators.completable.CompletableDefer
import javax.inject.Inject

internal class SearchLocalDataSourceImpl @Inject constructor(
    private val searchPref: SearchPref,
    private val schedulerProvider: SchedulerProvider
) : SearchLocalDataSource {
    override var searchList: Set<String>?
        get() = searchPref.searchList
        set(value) {
            searchPref.searchList = value
        }

    override fun save(keyword: String): Completable {
        return CompletableDefer {
            if (searchPref.searchList?.size!! > 4) {
                searchPref.searchList = searchPref.searchList?.minusElement(searchPref.searchList!!.elementAt(0))
                searchPref.searchList = searchPref.searchList?.plusElement(keyword)
            } else {
                searchPref.searchList = searchPref.searchList?.plusElement(keyword)
            }
            Completable.complete()
        }.subscribeOn(schedulerProvider.io)
            .mapToDataError()
    }
}