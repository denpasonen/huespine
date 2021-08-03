package com.rightcode.huespine.util.databinding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.SimpleItemAnimator
import androidx.viewpager2.widget.ViewPager2
import com.rightcode.huespine.model.Identifiable
import com.rightcode.huespine.util.ext.recyclerView
import com.rightcode.huespine.view.base.BaseRecyclerViewAdapter

@Suppress("UNCHECKED_CAST")
@BindingAdapter("list")
fun <ADT : BaseRecyclerViewAdapter<E, *>, E : Identifiable> ViewPager2.bindList(list: List<E>?) {
    (this.recyclerView.itemAnimator as? SimpleItemAnimator)?.supportsChangeAnimations = false
    (this.adapter as? ADT)?.submitList(list)
}