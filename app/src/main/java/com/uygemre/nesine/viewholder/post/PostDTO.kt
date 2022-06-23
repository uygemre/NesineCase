package com.uygemre.nesine.viewholder.post

import android.os.Parcelable
import com.uygemre.nesine.constants.RecyclerViewAdapterConstants.TYPES.TYPE_POST
import com.uygemre.nesine.recyclerview.DisplayItem
import kotlinx.parcelize.Parcelize

@Parcelize
data class PostDTO(
    var userId: Int? = null,
    var id: Int? = null,
    var title: String? = null,
    var body: String? = null
) : Parcelable, DisplayItem(TYPE_POST)
