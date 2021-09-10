package com.jlpay.filemanager.ui

import android.os.Bundle
import com.jlpay.filemanager.R
import com.jlpay.filemanager.common.FileActivity
import com.jlpay.filemanager.content.FILE_START_PATH_KEY

class FileListActivity : FileActivity() {

    private var specifyPath: String? = "" // 指定目录

    override fun getContentView() = R.layout.activity_file_list

    override fun init(savedInstanceState: Bundle?) {
        setSortSelectId()
        specifyPath = intent.getStringExtra(FILE_START_PATH_KEY)
    }

    private fun setSortSelectId() {
        TODO("Not yet implemented")
    }

}