package com.rightcode.huespine.domain.model

import android.view.View

data class ProfileCharacters(
    val id: Int = 0,
    val name: String = "",
    val image: String = "",
    val order: Long,
    var visible: Int = View.INVISIBLE
)
