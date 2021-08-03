package com.rightcode.huespine.util.ext

import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

fun TabLayout.setupWithViewPager2(
    viewPager2: ViewPager2,
    titleBlock: ((TabLayout.Tab, Int) -> Unit)
) {
    TabLayoutMediator(
        this, viewPager2
    ) { tab, position ->
        run {
            titleBlock.invoke(tab, position)
        }
    }.attach()
}


