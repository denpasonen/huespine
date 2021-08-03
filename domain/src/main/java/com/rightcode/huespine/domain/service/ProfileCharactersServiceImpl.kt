package com.rightcode.huespine.domain.service

import com.rightcode.huespine.domain.repository.ProfileCharactersRepository
import javax.inject.Inject

class ProfileCharactersServiceImpl @Inject constructor(
    private val profileCharacterRepository: ProfileCharactersRepository,
) : ProfileCharactersService {
    override fun getProfileCharacters() = profileCharacterRepository.getProfileCharacters()
}