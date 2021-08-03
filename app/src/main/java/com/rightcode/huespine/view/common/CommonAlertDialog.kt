package com.rightcode.huespine.view.common

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.*
import androidx.annotation.StyleRes
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import com.rightcode.huespine.R
import com.rightcode.huespine.databinding.FragmentAlertDialogBinding
import com.rightcode.huespine.view.base.FragmentLauncher
import kotlin.reflect.KClass

class CommonAlertDialog : DialogFragment(), DialogInterface.OnKeyListener {
    private lateinit var viewDataBinding: FragmentAlertDialogBinding
    private val isSingleButton: Boolean by lazy {
        requireArguments().getBoolean(KEY_SINGLE_BUTTON, false)
    }
    private val title: String by lazy {
        requireArguments().getString(KEY_TITLE, "")
    }
    private val positiveContent: String by lazy {
        requireArguments().getString(KEY_POSITIVE_CONTENT, "")
    }
    var positiveEvent: (() -> Unit)? = null
    private val negativeContent: String by lazy {
        requireArguments().getString(KEY_NEGATIVE_CONTENT, "")
    }
    var negativeEvent: (() -> Unit)? = null

    @StyleRes
    protected open val styleResId: Int = STYLE_NO_FRAME

    @StyleRes
    protected open val themeResId: Int = R.style.Dialog_Onboard

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCancelable = false
        setStyle(styleResId, themeResId)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState).apply {
            setOnKeyListener(this@CommonAlertDialog)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewDataBinding = FragmentAlertDialogBinding.inflate(inflater, container, false)
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.isSingleButton = isSingleButton

        with(viewDataBinding.tvAlertTitle) {
            text = title
            movementMethod = ScrollingMovementMethod()
        }

        with(viewDataBinding.btnAlertPositive) {
            text = positiveContent
            setOnClickListener {
                positiveEvent?.invoke()
                dismiss()
            }
        }

        with(viewDataBinding.btnAlertNegative) {
            text = negativeContent
            setOnClickListener {
                negativeEvent?.invoke()
                dismiss()
            }
        }
    }

    override fun onKey(dialog: DialogInterface?, keyCode: Int, event: KeyEvent?): Boolean {
        return keyCode == KeyEvent.KEYCODE_BACK &&
                event?.action == KeyEvent.ACTION_UP &&
                onBackPressed()
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

    protected open fun onBackPressed(): Boolean {
        negativeEvent?.invoke()
        return false
    }

    companion object : FragmentLauncher<CommonAlertDialog>() {
        private const val KEY_SINGLE_BUTTON = "keySingleButton"
        private const val KEY_TITLE = "keyTitle"
        private const val KEY_POSITIVE_CONTENT = "keyPositiveContent"
        private const val KEY_NEGATIVE_CONTENT = "keyNegativeContent"

        override val fragmentClass: KClass<CommonAlertDialog>
            get() = CommonAlertDialog::class

        @JvmOverloads
        fun newInstance(
            isSingleButton: Boolean,
            title: String,
            positiveContent: String = "확인",
            positiveEvent: (() -> Unit)? = null,
            negativeContent: String = "취소",
            negativeEvent: (() -> Unit)? = null
        ): CommonAlertDialog {
            return newInstance().apply {
                arguments = bundleOf(
                    KEY_SINGLE_BUTTON to isSingleButton,
                    KEY_TITLE to title,
                    KEY_POSITIVE_CONTENT to positiveContent,
                    KEY_NEGATIVE_CONTENT to negativeContent
                )
            }.also { dialogFragment ->
                dialogFragment.positiveEvent = positiveEvent
                dialogFragment.negativeEvent = negativeEvent
            }
        }

        fun newInstanceWithMessage(title: String): CommonAlertDialog {
            return newInstance(true, title)
        }
    }
}
