package com.comst.todoapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.comst.todoapp.data.dao.ContentDao
import com.comst.todoapp.model.ContentEntity

@Database(entities = [ContentEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contentDao() : ContentDao
}