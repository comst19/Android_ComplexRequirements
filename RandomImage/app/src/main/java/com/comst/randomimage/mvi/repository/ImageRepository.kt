package com.comst.randomimage.mvi.repository

import com.comst.randomimage.mvi.model.Image

interface ImageRepository {

    suspend fun getRandomImage() : Image
}