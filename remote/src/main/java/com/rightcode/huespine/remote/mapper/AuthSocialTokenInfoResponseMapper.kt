package com.rightcode.huespine.remote.mapper

internal object AuthSocialTokenInfoResponseMapper : Mapper<Pair<String, Map<String, Any>>, String> {
    override fun mapToData(from: Pair<String, Map<String, Any>>): String {
        val (type, response) = from
        return (response["email"] as? String) ?: ""
    }
}