package com.rightcode.huespine.util.ext

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager


fun DialogFragment.showSafely(fragmentManager: FragmentManager?, tag: String?) {
    if (fragmentManager == null || tag == null) return
    if (fragmentManager.isDestroyed || fragmentManager.isStateSaved) return

    show(fragmentManager, tag)
}

fun DialogFragment.dismissSafely() {
    if (this.isStateSaved) {
        this.dismissAllowingStateLoss()
    } else {
        this.dismiss()
    }
}