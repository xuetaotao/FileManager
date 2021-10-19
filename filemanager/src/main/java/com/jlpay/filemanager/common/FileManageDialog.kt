package com.jlpay.filemanager.common

import android.app.Dialog
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

internal abstract class FileManageDialog : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layoutID = getContentView()
        if (layoutID <= 0) {
            throw NullPointerException("DialogFragment ContentView is not null")
        }
        return inflater.inflate(layoutID, container, false)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return createDialog(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init(savedInstanceState)
        dialog?.setOnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK && event.action == KeyEvent.ACTION_DOWN) {
                onBackPressed()
            } else {
                false
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }

    abstract fun init(savedInstanceState: Bundle?)

    abstract fun createDialog(savedInstanceState: Bundle?): Dialog

    abstract fun getContentView(): Int

    /**
     * 返回true 拦截，否则销毁
     */
    open fun onBackPressed() = false
}