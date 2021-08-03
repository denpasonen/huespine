package com.rightcode.huespine.data.source.remote

import com.rightcode.huespine.data.model.ProfileCharactersData
import io.reactivex.Single


interface ProfileCharactersRemoteDataSource {
    fun getProfileCharacters(): Single<List<ProfileCharactersData>>
}
