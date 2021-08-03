package com.rightcode.huespine.data.source.local

import io.reactivex.Completable

interface SearchLocalDataSource {

    var searchList: Set<String>?

    fun save(keyword: String): Completable
}