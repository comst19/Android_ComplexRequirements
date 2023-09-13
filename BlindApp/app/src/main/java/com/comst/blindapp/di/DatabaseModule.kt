package com.comst.blindapp.di

import android.content.Context
import androidx.room.Room
import com.comst.blindapp.data.source.local.AppDatabase
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Singleton
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun providesDataBase(@ApplicationContext context : Context) : AppDatabase{
        return Room.databaseBuilder(context, AppDatabase::class.java, "chapter8.db")
            .fallbackToDestructiveMigration()
            .build()
    }
}