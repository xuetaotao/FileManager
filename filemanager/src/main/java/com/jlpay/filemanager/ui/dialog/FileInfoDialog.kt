package com.jlpay.filemanager.ui.dialog

import android.app.Dialog
import android.os.Bundle
import android.os.Handler
import android.os.Message
import com.jlpay.filemanager.common.FileManageDialog
import com.jlpay.filemanager.common.FileType
import com.jlpay.filemanager.content.FileBean
import com.jlpay.filemanager.content.FileInfoBean
import java.lang.ref.WeakReference

internal class FileInfoDialog : FileManageDialog(), Runnable {

    companion object {
        fun newInstance(bean: FileBean) = FileInfoDialog().apply {
            arguments = Bundle().apply {
                putParcelable("fileBean", bean)
            }
        }
    }

    private var handler: InfoHandler? = null

    private lateinit var fileType: FileType

    class InfoHandler(dialog: FileInfoDialog) : Handler() {

        private val week: WeakReference<FileInfoDialog> by lazy {
            WeakReference<FileInfoDialog>(dialog)
        }

        override fun handleMessage(msg: Message) {
            if (msg.what == 0) {
                val bean = msg.obj as FileInfoBean
                week.get()?.apply {
                    when (fileType) {
//                        is AudioType ->
                        //TODO
                    }
                }
            }
        }
    }

    override fun init(savedInstanceState: Bundle?) {
        TODO("Not yet implemented")
    }

    override fun createDialog(savedInstanceState: Bundle?): Dialog {
        TODO("Not yet implemented")
    }

    override fun getContentView(): Int {
        TODO("Not yet implemented")
    }

    override fun run() {
        TODO("Not yet implemented")
    }
}