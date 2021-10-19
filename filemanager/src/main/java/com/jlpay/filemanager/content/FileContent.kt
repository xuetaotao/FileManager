package com.jlpay.filemanager.content

import android.content.Context
import androidx.core.content.ContextCompat
import com.jlpay.filemanager.R
import com.jlpay.filemanager.common.FileManageHelp


/** 默认资源 */
const val FILE_DEFAULT = -1


fun getFileHelp() = FileManageHelp.getInstance()
fun getFileConfig() = getFileHelp().getConfiguration()


// 下面属性、方法暂不对外开放 =======================================================================

internal const val FILE_START_PATH_KEY = "fileStartPath"


internal fun Context.getColorById(colorID: Int) = ContextCompat.getColor(this, colorID)

internal fun throwError(title: String) {
    throw IllegalArgumentException("FileConfiguration $title error")
}

internal val lineColor: Int
    get() {
        return if (getFileConfig().resources.lineColor == FILE_DEFAULT) R.color.file_line_color
        else getFileConfig().resources.lineColor
    }