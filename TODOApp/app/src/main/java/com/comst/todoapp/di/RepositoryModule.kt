package com.comst.todoapp.di

import com.comst.todoapp.data.dao.ContentDao
import com.comst.todoapp.repository.ContentRepository
import com.comst.todoapp.repository.ContentRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun providesContentRepository(contentDao: ContentDao) : ContentRepository
    = ContentRepositoryImpl(contentDao)
}