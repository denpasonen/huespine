package com.rightcode.huespine.view.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.ViewDataBinding
import com.rightcode.huespine.BR

abstract class BaseArrayAdapter<T>(
    context: Context,
    val enablePlaceholder: Boolean = true
) : ArrayAdapter<T>(context, 0, arrayListOf()) {
    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)
    private var hasInitialSubmitted = false
    private var runAfterSubmit: Runnable? = null

    init {
        if (enablePlaceholder) {
            this.add(null)
        }
    }

    open fun submitList(list: List<T>?) {
        this.clear()
        if (enablePlaceholder) {
            this.add(null)
        }
        if (list != null) {
            this.addAll(list)
        }
        this.notifyDataSetChanged()

        if (!hasInitialSubmitted) {
            hasInitialSubmitted = true
            this.runAfterSubmit?.run()
        }
    }

    fun runAfterSubmit(runnable: Runnable) {
        this.runAfterSubmit = runnable
    }

    @Suppress("UNCHECKED_CAST")
    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return if (convertView == null) {
            val viewHolder = onCreateDropDownViewHolder(layoutInflater, parent)
            viewHolder.onBind(getItem(position))
            return viewHolder.itemView.apply {
                tag = viewHolder
            }
        } else {
            val viewHolder = convertView.tag as BaseViewHolder<T>
            viewHolder.onBind(getItem(position))
            convertView
        }
    }


    @Suppress("UNCHECKED_CAST")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return if (convertView == null) {
            val viewHolder = onCreateViewHolder(layoutInflater, parent)
            viewHolder.onBind(getItem(position))
            return viewHolder.itemView.apply {
                tag = viewHolder
            }
        } else {
            val viewHolder = convertView.tag as BaseViewHolder<T>
            viewHolder.onBind(getItem(position))
            convertView
        }
    }

    abstract fun onCreateDropDownViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): BaseViewHolder<T>

    abstract fun onCreateViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): BaseViewHolder<T>

    open class BaseViewHolder<T>(
        private val viewDataBinding: ViewDataBinding
    ) {
        val itemView: View = viewDataBinding.root

        open fun onBind(item: T?) {
            viewDataBinding.setVariable(BR.item, item)
            viewDataBinding.executePendingBindings()
        }
    }
}