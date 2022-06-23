package com.uygemre.nesine.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class ViewHolder<T>(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    var itemClickListener: ((item: DisplayItem, position: Int) -> Unit)? = null
    var itemViewClickListener: ((view:View, item: DisplayItem, position: Int) -> Unit)? = null
    var itemLongClickListener: ((item: DisplayItem, position: Int) -> Boolean)? = null
    abstract fun bind(item: T)
	open fun onAttachAdapter() {}
	open fun onDetachAdapter() {}
}

