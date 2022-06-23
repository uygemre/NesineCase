package com.uygemre.nesine.recyclerview

import androidx.recyclerview.widget.RecyclerView

interface ViewHolderBinder {
    fun bind(holder: RecyclerView.ViewHolder, item: DisplayItem)
}