package com.rightcode.huespine.util.databinding.listener

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

abstract class OnReachBottomScrollListener : RecyclerView.OnScrollListener() {
    private var previousTotalItemCount: Int = 0
    private var isLoading: Boolean = true
    private val visibleThreshold: Int = VISIBLE_THRESHOLD

    private fun getVisibleThreshold(recyclerView: RecyclerView): Int {
        return when (val layoutManager = recyclerView.layoutManager) {
            is LinearLayoutManager -> visibleThreshold
            is GridLayoutManager -> visibleThreshold * layoutManager.spanCount
            is StaggeredGridLayoutManager -> visibleThreshold * layoutManager.spanCount
            else -> visibleThreshold
        }
    }

    private fun getLastVisibleItemPosition(recyclerView: RecyclerView): Int? {
        return when (val layoutManager = recyclerView.layoutManager) {
            is LinearLayoutManager -> layoutManager.findLastCompletelyVisibleItemPosition()
            is GridLayoutManager -> layoutManager.findLastCompletelyVisibleItemPosition()
            is StaggeredGridLayoutManager -> layoutManager.findLastVisibleItemPositions(null)
                .maxOrNull()
            else -> null
        }
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        val totalItemCount = recyclerView.layoutManager?.itemCount ?: 0
        val lastVisibleItemPosition = getLastVisibleItemPosition(recyclerView) ?: return

        if (!isLoading && (lastVisibleItemPosition + getVisibleThreshold(recyclerView)) >= totalItemCount) {
            this.isLoading = true
            this.onLoadMore(recyclerView)
        }

        if (totalItemCount < previousTotalItemCount) {
            this.previousTotalItemCount = totalItemCount
            this.isLoading = (totalItemCount == 0)
        }

        if (isLoading && (totalItemCount > previousTotalItemCount)) {
            this.isLoading = false
            this.previousTotalItemCount = totalItemCount
        }
    }

    abstract fun onLoadMore(view: RecyclerView)

    companion object {
        const val VISIBLE_THRESHOLD = 5
    }
}