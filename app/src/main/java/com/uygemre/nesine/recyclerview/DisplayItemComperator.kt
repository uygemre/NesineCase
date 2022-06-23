package com.uygemre.nesine.recyclerview

interface DisplayItemComperator {

    fun areItemsSame(oldItem: DisplayItem?, newItem: DisplayItem?): Boolean
    fun areContentsSame(oldItem: DisplayItem?, newItem: DisplayItem?): Boolean
}