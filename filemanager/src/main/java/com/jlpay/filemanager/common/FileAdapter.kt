package com.jlpay.filemanager.common

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class FileAdapter<T>(protected var context: Context) :
    RecyclerView.Adapter<FileViewHolder>() {

    private var layoutID = -1
    private var datas: MutableList<T> = ArrayList<T>()

    constructor(context: Context, layoutID: Int) : this(context) {
        this.layoutID = layoutID
    }

    open fun getDatas() = datas

    open fun setDatas(list: MutableList<T>?) {
        clear()
        if (!list.isNullOrEmpty()) {
            if (datas.addAll(list)) {
                notifyDataSetChanged()
            }
        }
    }

    private fun clear(changeDataNow: Boolean = true) {
        datas.clear()
        if (changeDataNow) {
            notifyDataSetChanged()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FileViewHolder {
        val layoutRes = getLayoutID(viewType)
        if (layoutRes > 0) {
            val view = LayoutInflater.from(context).inflate(layoutRes, parent, false)
            return FileViewHolder(view)
        } else {
            throw NullPointerException("adapter layoutId is not null")
        }
    }

    open fun getLayoutID(viewType: Int) = layoutID

    var itemClick: ((View, Int, T) -> Unit)? = null
    var itemLongClick: ((View, Int, T) -> Boolean)? = null

    override fun onBindViewHolder(holder: FileViewHolder, position: Int) {
        holder.setOnItemClickListener {
            itemClick?.invoke(this, position, getItem(position))
        }
        holder.setOnItemLongClickListener {
            itemLongClick?.invoke(this, position, getItem(position)) ?: true
        }
        bindView(holder, getItem(position), position)
    }

    protected abstract fun bindView(holder: FileViewHolder, item: T, position: Int)

    private fun getItem(position: Int) = datas[position]

    override fun getItemCount() = datas.size


    open fun addAll(list: MutableList<T>) {
        val oldSize = itemCount
        if (datas.addAll(list)) {
            notifyItemRangeChanged(oldSize, list.size)
        }
    }

    open fun addItem(position: Int, t: T) {
        datas.add(position, t)
        notifyItemInserted(position)
    }

    open fun setItem(position: Int, t: T) {
        if (itemCount > 0) {
            datas[position] = t
            notifyItemChanged(position)
        }
    }

    open fun remove(position: Int, changeDataNow: Boolean = true) {
        if (itemCount > 0) {
            datas.removeAt(position)
        }
        if (changeDataNow) {
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, itemCount)
        }
    }
}