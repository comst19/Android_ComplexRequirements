package com.comst.todoapp.repository

import com.comst.todoapp.data.dao.ContentDao
import com.comst.todoapp.model.ContentEntity
import javax.inject.Inject

class ContentRepositoryImpl @Inject constructor(private val contentDao : ContentDao) : ContentRepository {

    override suspend fun insert(item: ContentEntity) {
        contentDao.insert(item)
    }
}