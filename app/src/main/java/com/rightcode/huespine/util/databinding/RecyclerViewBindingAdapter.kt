package com.rightcode.huespine.util.databinding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import com.rightcode.huespine.model.Identifiable
import com.rightcode.huespine.util.databinding.listener.OnReachBottomScrollListener
import com.rightcode.huespine.view.base.BaseRecyclerViewAdapter

@Suppress("UNCHECKED_CAST")
@BindingAdapter("list")
fun <ADT : BaseRecyclerViewAdapter<E, *>, E : Identifiable> RecyclerView.submitList(list: List<E>?) {
    (this.itemAnimator as? SimpleItemAnimator)?.supportsChangeAnimations = false
    (this.adapter as? ADT)?.submitList(list)
}

@BindingAdapter("onReachBottom")
inline fun RecyclerView.bindReachBottom(
    crossinline listener: (() -> Unit)
) {
    this.addOnScrollListener(object : OnReachBottomScrollListener() {
        override fun onLoadMore(view: RecyclerView) {
            listener.invoke()
        }
    })
}