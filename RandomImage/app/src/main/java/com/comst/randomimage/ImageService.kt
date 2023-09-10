package com.comst.randomimage

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ImageService {

    @Headers("Authorization: Client-ID ${BuildConfig.RANDOM_IMAGE_KEY}")
    @GET("photos/random")
    fun getRandomImage() : Call<ImageResponse>
}