package com.rightcode.huespine.util.ext

import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import com.google.android.material.tabs.TabLayout

inline fun TabLayout.tabViewStrategy(crossinline block: (View) -> Unit) {
    val tabSlidingIndicator = this.children.firstOrNull()
            as? ViewGroup
        ?: return
    tabSlidingIndicator.children.forEach(block)
}