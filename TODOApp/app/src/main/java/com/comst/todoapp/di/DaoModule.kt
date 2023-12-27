package com.comst.todoapp.di

import com.comst.todoapp.data.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Singleton
    @Provides
    fun providesContentDao(appDatabase: AppDatabase) = appDatabase.contentDao()
}