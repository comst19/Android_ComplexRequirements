package com.comst.todoapp.repository

import com.comst.todoapp.model.ContentEntity
import kotlinx.coroutines.flow.Flow

interface ContentRepository {

    fun loadList() : Flow<List<ContentEntity>>
    suspend fun insert(item : ContentEntity)

    suspend fun modify(item : ContentEntity)

    suspend fun delete(item : ContentEntity)
}