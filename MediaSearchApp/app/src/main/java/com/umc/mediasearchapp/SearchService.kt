package com.umc.mediasearchapp

import android.database.Observable
import com.umc.mediasearchapp.model.ImageListResponse
import com.umc.mediasearchapp.model.VideoListResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SearchService {

    @Headers("Authorization: KakaoAK f1dfe53d8c0ff239e4695a7eea4e5e1e")
    @GET("image")
    fun searchImage(@Query("query") query : String) : Observable<ImageListResponse>

    @Headers("Authorization: KakaoAK f1dfe53d8c0ff239e4695a7eea4e5e1e")
    @GET("vclip")
    fun searchVideo(@Query("query") query : String) : Observable<VideoListResponse>
}