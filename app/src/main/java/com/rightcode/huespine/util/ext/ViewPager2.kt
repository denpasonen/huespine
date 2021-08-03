package com.rightcode.huespine.util.ext

import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

val ViewPager2.recyclerView: RecyclerView
    get() = this.children.first() as RecyclerView