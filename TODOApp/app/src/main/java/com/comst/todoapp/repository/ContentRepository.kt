package com.comst.todoapp.repository

import com.comst.todoapp.model.ContentEntity

interface ContentRepository {

    suspend fun insert(item : ContentEntity)
}