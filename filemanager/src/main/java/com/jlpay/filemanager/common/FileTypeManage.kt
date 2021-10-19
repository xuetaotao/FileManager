package com.jlpay.filemanager.common

/**
 * 文件类型 管理
 */
internal class FileTypeManage {

    private object Builder {
        val MANAGER = FileTypeManage()
    }

    companion object {
        fun getTypeManager() = Builder.MANAGER
    }

//    var fileType: FileType
}