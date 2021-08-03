package com.rightcode.huespine.util.databinding

import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

@BindingAdapter("refreshing")
fun SwipeRefreshLayout.bindRefreshing(isRefreshing: Boolean) {
    this.isRefreshing = isRefreshing
}

@BindingAdapter("onRefresh")
fun SwipeRefreshLayout.bindRefresh(listener: SwipeRefreshLayout.OnRefreshListener) {
    this.setOnRefreshListener(listener)
}