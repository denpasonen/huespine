package com.rightcode.huespine.view.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rightcode.huespine.BR
import com.rightcode.huespine.model.Identifiable
import com.rightcode.huespine.model.Viewable
import kotlin.reflect.KClass

abstract class BaseRecyclerViewAdapter<T : Identifiable, E : Enum<E>>(
    private val viewTypeClass: KClass<E>
) : ListAdapter<T, BaseRecyclerViewAdapter.BaseViewHolder<T>>(
    object : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem.identifier == newItem.identifier
        }

        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem.same(newItem)
        }
    }
) {
    private val enumConstants = viewTypeClass.java.enumConstants!!
    private var layoutInflater: LayoutInflater? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        layoutInflater = LayoutInflater.from(recyclerView.context)
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        layoutInflater = null
        super.onDetachedFromRecyclerView(recyclerView)
    }

    override fun getItemViewType(position: Int): Int {
        return kotlin.runCatching {
            getItemViewType(position, currentList[position]).ordinal
        }.getOrDefault(RecyclerView.INVALID_TYPE)
    }

    @Suppress("UNCHECKED_CAST")
    open fun getItemViewType(position: Int, item: T): E {
        return if (item is Viewable<*>) {
            item.viewType as E
        } else {
            throw IllegalStateException("no view type provided")
        }
    }

    fun convertViewType(viewType: Int): E {
        return enumConstants[viewType]
    }

    fun getItemViewTypeAsEnum(position: Int): E {
        return this.convertViewType(this.getItemViewType(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        return onCreateViewHolder(
            layoutInflater!!,
            parent,
            viewTypeClass.java.enumConstants!![viewType]
        )
    }

    abstract fun onCreateViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        viewType: E
    ): BaseViewHolder<T>

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        val item = currentList.getOrNull(position) ?: return
        holder.onBind(item)
    }

    override fun onViewRecycled(holder: BaseViewHolder<T>) {
        holder.onRecycle()
        super.onViewRecycled(holder)
    }

    override fun onViewAttachedToWindow(holder: BaseViewHolder<T>) {
        super.onViewAttachedToWindow(holder)
        holder.onAttach()
    }

    override fun onViewDetachedFromWindow(holder: BaseViewHolder<T>) {
        holder.onDetach()
        super.onViewDetachedFromWindow(holder)
    }

    override fun getItem(position: Int): T? {
        return if (position == RecyclerView.NO_POSITION || position !in (0 until itemCount)) {
            null
        } else {
            runCatching { super.getItem(position) }.getOrNull()
        }
    }

    open class BaseViewHolder<T : Identifiable>(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        protected val viewDataBinding: ViewDataBinding = DataBindingUtil.bind(itemView)!!

        open fun onBind(item: T) {
            with(viewDataBinding) {
                setVariable(BR.item, item)
                executePendingBindings()
            }
        }

        fun onAttach() {

        }

        fun onDetach() {

        }

        open fun onRecycle() {

        }
    }
}