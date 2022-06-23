package com.uygemre.nesine.adapter

import com.uygemre.nesine.constants.RecyclerViewAdapterConstants
import com.uygemre.nesine.recyclerview.DefaultDisplayItemComperator
import com.uygemre.nesine.recyclerview.RecyclerViewAdapter

class CaseRecyclerViewAdapter {

    fun getAdapter() = _adapter

    private val _adapter = RecyclerViewAdapter(
        itemComparator = DefaultDisplayItemComperator(),
        viewBinderFactoryMap = RecyclerViewAdapterConstants().binderFactoryMap,
        viewHolderFactoryMap = RecyclerViewAdapterConstants().holderFactoryMap
    )
}