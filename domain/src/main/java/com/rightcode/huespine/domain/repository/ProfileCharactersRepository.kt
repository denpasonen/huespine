package com.rightcode.huespine.domain.repository


import com.rightcode.huespine.domain.model.ProfileCharacters
import io.reactivex.Single

interface ProfileCharactersRepository {
    fun getProfileCharacters(): Single<List<ProfileCharacters>>
}