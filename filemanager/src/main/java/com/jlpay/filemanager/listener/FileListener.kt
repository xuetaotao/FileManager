package com.jlpay.filemanager.listener

import android.content.Context
import com.jlpay.filemanager.content.FileBean

/**
 * 文件操作，耗时的文件操作建议放在 非 UI线程中
 */
open class FileOperateListener {

    /**
     * 文件详情
     */
    open fun fileInfo(bean: FileBean, context: Context) {
//        val tag =
        //TODO
    }
}