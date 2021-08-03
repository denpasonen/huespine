package com.rightcode.huespine.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.rightcode.huespine.BR
import com.rightcode.huespine.util.lifecycle.observeNotNull

abstract class BaseFragment<VDB, VM>(
) : Fragment() where VDB : ViewDataBinding, VM : ViewModelType<*, *> {
    @LayoutRes
    protected open val layoutResId: Int = 0
    private var viewDataBinding: VDB? = null
    protected abstract val viewModel: VM

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

            onWillAttachViewModel(viewLifecycleOwner, this, viewModel)
            setVariable(BR.input, viewModel.input)
            setVariable(BR.output, viewModel.output)
            onDidAttachViewModel(viewLifecycleOwner, this, viewModel)
        }
    }

    override fun onDestroyView() {
        onWillDetachViewModel(requireViewDataBinding(), viewModel)
        viewDataBinding = null
        onDidDetachViewModel()
        super.onDestroyView()
    }

    @Throws(IllegalStateException::class)
    protected fun requireViewDataBinding(): VDB {
        if (viewDataBinding == null) {
            throw IllegalStateException("viewDataBinding is null")
        }
        return viewDataBinding!!
    }

    protected open fun onWillAttachViewModel(
        lifecycleOwner: LifecycleOwner,
        viewDataBinding: VDB,
        viewModel: VM
    ) {
        //nothing
    }

    protected open fun onDidAttachViewModel(
        lifecycleOwner: LifecycleOwner,
        viewDataBinding: VDB,
        viewModel: VM
    ) {
        //nothing
    }

    protected open fun onWillDetachViewModel(
        viewDataBinding: VDB,
        viewModel: VM
    ) {
        //nothing
    }

    protected open fun onDidDetachViewModel() {
        //nothing
    }

    protected fun <T> LiveData<T>.observe(observer: (T) -> Unit) =
        observeNotNull(viewLifecycleOwner, observer)
}