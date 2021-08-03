package com.rightcode.huespine.view.base

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.annotation.StyleRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.LiveData
import com.rightcode.huespine.R
import com.rightcode.huespine.util.lifecycle.observeNotNull

abstract class BasePlainDialogFragment<VDB>(
) : DialogFragment(),
    DialogInterface.OnKeyListener where VDB : ViewDataBinding {

    @LayoutRes
    protected open val layoutResId: Int = 0
    protected var _viewDataBinding: VDB? = null
    protected val viewDataBinding: VDB
        get() = _viewDataBinding!!

    @StyleRes
    protected open val styleResId: Int = STYLE_NO_FRAME

    @StyleRes
    protected open val themeResId: Int = R.style.Dialog_Onboard

    @StyleRes
    protected open val animationResId: Int = R.style.DialogAnim

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(styleResId, themeResId)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState).also { dialog ->
            dialog.window?.attributes?.windowAnimations = animationResId
            dialog.setOnKeyListener(this)
        }
    }

    override fun onKey(dialog: DialogInterface?, keyCode: Int, event: KeyEvent?): Boolean {
        return keyCode == KeyEvent.KEYCODE_BACK &&
                event?.action == KeyEvent.ACTION_UP &&
                onBackPressed()
    }

    protected open fun onBackPressed(): Boolean {
        return false
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutResId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _viewDataBinding = DataBindingUtil.bind<VDB>(view)?.apply {
            lifecycleOwner = viewLifecycleOwner
        }
    }

    override fun onDestroyView() {
        _viewDataBinding = null
        super.onDestroyView()
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

    @Throws(IllegalStateException::class)
    protected fun requireViewDataBinding(): VDB {
        return viewDataBinding
    }

    protected fun <T> LiveData<T>.observe(observer: (T) -> Unit) =
        observeNotNull(viewLifecycleOwner, observer)

}