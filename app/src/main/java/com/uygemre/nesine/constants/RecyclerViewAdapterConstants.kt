package com.uygemre.nesine.constants

import com.uygemre.nesine.viewholder.post.PostViewHolder

class RecyclerViewAdapterConstants {

    object TYPES {
        const val TYPE_NONE = 0
        const val TYPE_POST = 1
    }

    val binderFactoryMap = mutableMapOf(
        TYPES.TYPE_POST to PostViewHolder.BinderFactory()
    )
    val holderFactoryMap = mutableMapOf(
        TYPES.TYPE_POST to PostViewHolder.HolderFactory()
    )
}