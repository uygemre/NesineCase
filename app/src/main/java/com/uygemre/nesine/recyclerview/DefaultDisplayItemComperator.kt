package com.uygemre.nesine.recyclerview

class DefaultDisplayItemComperator : DisplayItemComperator {

    override fun areItemsSame(oldItem: DisplayItem?, newItem: DisplayItem?): Boolean {
        return oldItem == newItem
    }

    override fun areContentsSame(oldItem: DisplayItem?, newItem: DisplayItem?): Boolean {
        return oldItem == newItem
    }
}