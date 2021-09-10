package com.jlpay.filemanager.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class FileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentView())
        init(savedInstanceState)
    }

    abstract fun init(savedInstanceState: Bundle?)

    abstract fun getContentView(): Int

}