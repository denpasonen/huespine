package com.rightcode.huespine.domain.service

import com.rightcode.huespine.domain.model.ProfileCharacters
import io.reactivex.Single

interface ProfileCharactersService {
    fun getProfileCharacters(): Single<List<ProfileCharacters>>
}