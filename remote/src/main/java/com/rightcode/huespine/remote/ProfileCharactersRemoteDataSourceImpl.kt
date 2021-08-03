package com.rightcode.huespine.remote

import com.rightcode.huespine.data.model.ProfileCharactersData
import com.rightcode.huespine.data.source.remote.ProfileCharactersRemoteDataSource
import com.rightcode.huespine.remote.mapper.ProfileCharactersListMapper
import com.rightcode.huespine.remote.retrofit.api.ProfileCharactersApi
import com.rightcode.huespine.remote.utils.rx.catchRemoteError
import com.google.gson.Gson
import io.reactivex.Single
import javax.inject.Inject

internal class ProfileCharactersRemoteDataSourceImpl @Inject constructor(
    private val api: ProfileCharactersApi,
    private val gson: Gson
) : ProfileCharactersRemoteDataSource {

    override fun getProfileCharacters(): Single<List<ProfileCharactersData>> =
        api.getProfileCharacters()
            .map(ProfileCharactersListMapper::mapToData)
            .catchRemoteError(gson)
}