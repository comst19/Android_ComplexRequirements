package com.example.shoppingmall.model

import com.google.gson.annotations.SerializedName

data class NetworkResponse (
    val sucess : Boolean,
    val code : Int,
    val message : String,
    val data : PageListResponse
)

data class PageListResponse(
    @SerializedName("list") val list : List<ListItem>,
    @SerializedName("page") val page : PageInfoResponse
)

data class PageInfoResponse(
    @SerializedName("currentPage") val currentPage : Int,
    @SerializedName("nextPage") val nextPage : Int ?,
    @SerializedName("totalPage") val totalPage : Int,
    @SerializedName("totalItems") val totalItems : Int
)