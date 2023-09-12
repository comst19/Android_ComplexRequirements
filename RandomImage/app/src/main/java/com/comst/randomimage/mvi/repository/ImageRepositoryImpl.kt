package com.comst.randomimage.mvi.repository

import com.comst.randomimage.RetrofitManager
import com.comst.randomimage.mvi.model.Image
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ImageRepositoryImpl(private val dispatcher: CoroutineDispatcher = Dispatchers.IO) : ImageRepository{

    override suspend fun getRandomImage() = withContext(dispatcher){
        RetrofitManager.imageService.getRandomImageSuspend().let {
            Image(it.urls.regular, it.color)
        }
    }

}