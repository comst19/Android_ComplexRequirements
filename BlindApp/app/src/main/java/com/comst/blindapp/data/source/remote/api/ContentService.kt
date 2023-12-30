package com.comst.blindapp.data.source.remote.api

import com.comst.blindapp.data.dto.ContentDto
import com.comst.blindapp.data.dto.ContentResponse
import com.comst.blindapp.data.dto.ListResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.DELETE

interface ContentService {

    @GET("list")
    suspend fun getList() : ListResponse

    @POST("save")
    suspend fun saveItem(@Body cntentDto : ContentDto) : ContentResponse

    @POST("update")
    suspend fun updateItem(@Body contentDto: ContentDto) : ContentResponse

    @DELETE("{id}")
    suspend fun deleteItem(@Path("id") id : Int) : ContentResponse
}