package com.rightcode.huespine.data

import com.rightcode.huespine.data.mapper.ProfileCharactersListMapper
import com.rightcode.huespine.data.source.remote.ProfileCharactersRemoteDataSource
import com.rightcode.huespine.domain.model.ProfileCharacters
import com.rightcode.huespine.domain.repository.ProfileCharactersRepository
import io.reactivex.Single
import javax.inject.Inject

class ProfileCharactersRepositoryImpl @Inject constructor(
    private val remote: ProfileCharactersRemoteDataSource,
) : ProfileCharactersRepository {

    override fun getProfileCharacters(): Single<List<ProfileCharacters>> =
        remote.getProfileCharacters()
            .map(ProfileCharactersListMapper::mapToDomain)
}