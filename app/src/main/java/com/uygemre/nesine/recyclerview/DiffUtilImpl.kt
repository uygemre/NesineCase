package com.uygemre.nesine.recyclerview

import androidx.recyclerview.widget.DiffUtil

class DiffUtilImpl(
    private val oldItems: List<DisplayItem?>?,
    private val newItems: List<DisplayItem?>?,
    private val comparator: DisplayItemComperator
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        comparator.areItemsSame(
            oldItems?.getOrNull(index = oldItemPosition),
            newItems?.getOrNull(index = newItemPosition)
        )

    override fun getOldListSize(): Int = oldItems?.size ?: 0

    override fun getNewListSize(): Int = newItems?.size ?: 0

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        comparator.areContentsSame(
            oldItems?.getOrNull(index = oldItemPosition),
            newItems?.getOrNull(index = newItemPosition)
        )
}