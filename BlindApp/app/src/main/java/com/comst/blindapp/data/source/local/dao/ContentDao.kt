package com.comst.blindapp.data.source.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.comst.blindapp.data.model.entitiy.ContentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ContentDao {

    @Query("SELECT * FROM Content ORDER BY createdDate DESC")
    fun selectAll() : Flow<List<ContentEntity>>

    @Delete
    suspend fun delete(item : ContentEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item : ContentEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items : List<ContentEntity>)

}