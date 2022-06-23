package com.uygemre.nesine.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GetPostsResponse(
    @SerializedName(value = "userId") val userId: Int? = null,
    @SerializedName(value = "id") val id: Int? = null,
    @SerializedName(value = "title") val title: String? = null,
    @SerializedName(value = "body") val body: String? = null,
) : Parcelable