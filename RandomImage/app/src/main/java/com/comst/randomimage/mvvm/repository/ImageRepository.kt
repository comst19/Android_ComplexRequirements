package com.comst.randomimage.mvvm.repository

import com.comst.randomimage.mvvm.model.Image
import io.reactivex.Single

interface ImageRepository {

    fun getRandomImage() : Single<Image>
}