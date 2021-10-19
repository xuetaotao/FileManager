package com.jlpay.filemanager.ui.adapter

import android.content.Context
import android.util.ArrayMap
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import com.jlpay.filemanager.R
import com.jlpay.filemanager.common.FileAdapter
import com.jlpay.filemanager.common.FileViewHolder
import com.jlpay.filemanager.content.*

class FileListAdapter(context: Context) : FileAdapter<FileBean>(context) {

    private var isQW = false

    private var config = getFileConfig()

    // box选中的数据
    private val boxMap by lazy {
        ArrayMap<Int, Boolean>()
    }

    var isManage = false
        set(value) {
            if (isQW) {
                if (value) {
                    notifyDataSetChanged()
                } else {
                    clearSelectMap()
                    clearCountMap()
                }
            } else {
                if (!value) {
                    clearSelectMap()
                    clearCountMap()
                }
            }
            field = value
        }

    private fun clearCountMap() {
        TODO("Not yet implemented")
    }

    private fun clearSelectMap() {
        TODO("Not yet implemented")
    }

    override fun bindView(holder: FileViewHolder, item: FileBean, position: Int) {
        if (item.isFile) {
            setFileData(holder, item, position)
        } else {
            setFolderData(holder, item, position)
        }
    }


    private fun setFileData(holder: FileViewHolder, item: FileBean, position: Int) {
        holder.apply {
            setText(R.id.item_file_list_file_nameTxt, item.fileName ?: "")
            setText(R.id.item_file_list_file_dateTxt, item.date ?: "")
            setText(R.id.item_file_list_file_sizeTxt, item.size ?: "")
            setBgColor(R.id.item_file_list_file_line, lineColor)
            setVisibility(R.id.item_file_list_file_line, position < itemCount - 1)
            setVisibility(R.id.item_file_file_box_pic, !isManage)
            when (config.boxStyle) {
                FileConfiguration.STYLE1 -> setVisibility(R.id.item_file_list_file_box1, isManage)
                FileConfiguration.STYLE2 -> setVisibility(R.id.item_file_list_file_box2, isManage)
                else -> throwError("boxStyle")
            }
        }
        val box1 = holder.getView<CheckBox>(R.id.item_file_list_file_box1)
        box1.isChecked = boxMap[position] ?: false
        box1.setOnClickListener {
            boxClick(position, item)
        }
        val box2 = holder.getView<TextView>(R.id.item_file_list_file_box2)
        box2.isSelected = boxMap[position] ?: false
        box2.setOnClickListener {
            box2.isSelected = !(boxMap[position] ?: false)
            boxClick(position, item)
        }

        val pic = holder.getView<ImageView>(R.id.item_file_list_file_pic).run {
//            FileTypeManage
        }
    }

    private fun boxClick(position: Int, item: FileBean) {
        TODO("Not yet implemented")
    }

    private fun setFolderData(holder: FileViewHolder, item: FileBean, position: Int) {
        TODO("Not yet implemented")
    }
}