package com.comst.blindapp.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.comst.blindapp.data.model.entitiy.ContentEntity
import com.comst.blindapp.data.source.local.dao.ContentDao

@Database(entities = [ContentEntity::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase(){

    abstract fun contentDao() : ContentDao
}