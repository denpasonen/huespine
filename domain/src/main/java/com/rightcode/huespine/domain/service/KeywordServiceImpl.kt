package com.rightcode.huespine.domain.service

import com.rightcode.huespine.domain.model.Keyword
import com.rightcode.huespine.domain.repository.KeywordRepository
import io.reactivex.Single
import javax.inject.Inject

class KeywordServiceImpl @Inject constructor(
    private val keywordRepository: KeywordRepository,
) : KeywordService {

    override fun getKeywords(): Single<List<Keyword>> = keywordRepository.getKeywords()

    override fun postKeywordLog(keyword: String) = keywordRepository.postKeywordLog(keyword)
}