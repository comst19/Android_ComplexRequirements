package com.comst.shoppingmall.di

import com.comst.shoppingmall.remote.MainService
import com.comst.shoppingmall.remote.repository.MainRepository
import com.comst.shoppingmall.remote.repository.MainRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object MainRepositoryModule {

    @ViewModelScoped
    @Provides
    fun providesMainRepository(
        mainService: MainService
    ) : MainRepository = MainRepositoryImpl(mainService)

}