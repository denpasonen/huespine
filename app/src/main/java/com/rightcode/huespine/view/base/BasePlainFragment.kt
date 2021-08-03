package com.rightcode.huespine.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import com.rightcode.huespine.util.lifecycle.observeNotNull

abstract class BasePlainFragment<VDB>(
) : Fragment() where VDB : ViewDataBinding {
    @LayoutRes
    protected open val layoutResId: Int = 0
    private var viewDataBinding: VDB? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutResId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding = DataBindingUtil.bind<VDB>(view)?.apply {
            lifecycleOwner = viewLifecycleOwner
        }
    }

    override fun onDestroyView() {
        viewDataBinding = null
        super.onDestroyView()
    }

    @Throws(IllegalStateException::class)
    protected fun requireViewDataBinding(): VDB {
        if (viewDataBinding == null) {
            throw IllegalStateException("viewDataBinding is null")
        }
        return viewDataBinding!!
    }

    protected fun <T> LiveData<T>.observe(observer: (T) -> Unit) =
        observeNotNull(viewLifecycleOwner, observer)
}