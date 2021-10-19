package com.jlpay.filemanager.common

import com.jlpay.filemanager.content.FileConfiguration
import com.jlpay.filemanager.listener.FileOperateListener

class FileManageHelp {

    private object Builder {
        val MANAGER = FileManageHelp()
    }

    companion object {
        @JvmStatic
        fun getInstance() = Builder.MANAGER
    }

    /**
     * 文件操作
     */
    private var fileOperateListener = FileOperateListener()
    internal fun getFileOperateListener() = fileOperateListener
    fun setFileOperateListener(fileOperateListener: FileOperateListener): FileManageHelp {
        this.fileOperateListener = fileOperateListener
        return this
    }

    /**
     * 文件的相关配置信息
     */
    private var config = FileConfiguration()
    fun getConfiguration() = config
    fun setConfiguration(config: FileConfiguration): FileManageHelp {
        this.config = config
        return this
    }

}