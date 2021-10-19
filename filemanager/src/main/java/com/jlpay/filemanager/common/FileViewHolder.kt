package com.jlpay.filemanager.common

import android.util.SparseArray
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jlpay.filemanager.content.getColorById

class FileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var array: SparseArray<View> = SparseArray()

    fun <V : View> getView(id: Int): V {
        var view: View? = array.get(id)
        if (view == null) {
            view = itemView.findViewById(id)
            array.put(id, view)
        }
        return view as V
    }

    fun setText(id: Int, msg: String) {
        val textView = getView<TextView>(id)
        textView.text = msg
    }

    fun setImageRes(id: Int, res: Int) {
        val pic = getView<ImageView>(id)
        pic.setImageResource(res)
    }

    fun setBgColor(id: Int, color: Int) {
        getView<View>(id).setBackgroundColor(itemView.context.getColorById(color))
    }

    fun setVisibility(id: Int, visibility: Int) {
        getView<View>(id).visibility = visibility
    }

    fun setVisibility(id: Int, isVisibility: Boolean) {
        getView<View>(id).visibility = if (isVisibility) View.VISIBLE else View.GONE
//        if (isVisibility) setVisibility(id, View.VISIBLE) else setVisibility(id, View.GONE)
    }

    fun setOnViewClickListener(id: Int, listener: View.() -> Unit) {
        getView<View>(id).setOnClickListener {
            listener.invoke(it)
//            listener(it)
        }
    }

    fun setOnItemClickListener(listener: View.() -> Unit) {
        itemView.setOnClickListener {
            listener.invoke(it)
            //等价于
//            listener(it)
        }
    }

    fun setOnItemLongClickListener(listener: View.() -> Boolean) {
        itemView.setOnLongClickListener {
            listener.invoke(it)
        }
    }
}