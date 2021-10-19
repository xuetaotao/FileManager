package com.jlpay.filemanager.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.jlpay.filemanager.R
import com.jlpay.filemanager.common.FileActivity
import com.jlpay.filemanager.content.FILE_START_PATH_KEY
import com.jlpay.filemanager.content.getFileConfig
import com.jlpay.filemanager.ui.adapter.FileListAdapter

class FileListActivity : FileActivity() {

    private var fileListAdapter: FileListAdapter? = null

    private var rootPath = "" // 根目录
    private var specifyPath: String? = "" // 指定目录
    private var nowPath: String? = "" // 当前目录

    private val backList by lazy {
        ArrayList<String>()
    }

    override fun getContentView() = R.layout.activity_file_list

    override fun init(savedInstanceState: Bundle?) {
        setSortSelectId()
        specifyPath = intent.getStringExtra(FILE_START_PATH_KEY)
        getFileConfig().filePath = specifyPath
        rootPath = specifyPath ?: ""
        backList.add(rootPath)
        nowPath = rootPath

        val file_list_toolBar = findViewById<Toolbar>(R.id.file_list_toolBar)
        file_list_toolBar.apply {
            inflateMenu(R.menu.file_list_menu)
            setOnMenuItemClickListener { menuItem -> menuItemClick(menuItem) }
        }

    }

    private fun menuItemClick(menuItem: MenuItem?): Boolean {
        when (menuItem?.itemId) {
            //完成
            R.id.menu_file_down -> {
                //TODO
            }
        }
        return true
    }

    private fun setSortSelectId() {
        TODO("Not yet implemented")
    }

}