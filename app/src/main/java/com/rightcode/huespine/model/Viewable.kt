package com.rightcode.huespine.model

interface Viewable<ViewType : Enum<ViewType>> {
    val viewType: ViewType
}