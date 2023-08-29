package com.umc.mediasearchapp.model

import com.google.gson.annotations.SerializedName
import java.util.Date

data class ImageListResponse(
    val documents : List<ImageItem>
)

data class ImageItem(
    @SerializedName("thumbnail_url") override val thumbnailUrl: String,
    @SerializedName("collection") val collection : String,
    @SerializedName("display_sitename") val siteName : String,
    @SerializedName("dpc_url") val docUrl : String,
    @SerializedName("datetime") override val dateTime: Date,
    override var isFavorite: Boolean = false
) : ListItem
