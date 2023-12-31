package com.comst.blindapp.data.repository

import com.comst.blindapp.data.model.ContentMapper.toEntity
import com.comst.blindapp.data.model.ContentMapper.toRequest
import com.comst.blindapp.data.source.local.dao.ContentDao
import com.comst.blindapp.data.source.remote.api.ContentService
import com.comst.blindapp.domain.model.Content
import com.comst.blindapp.domain.repository.ContentRepository
import okio.IOException
import javax.inject.Inject

class ContentRepositoryImpl @Inject constructor(
    private val contentService: ContentService,
    private val contentDao : ContentDao
) : ContentRepository {
    override suspend fun save(item: Content): Boolean {
        return try {
            contentService.saveItem(item.toRequest())
            contentDao.insert(item.toEntity())
            true
        } catch (e : IOException){
            false
        }
    }
}