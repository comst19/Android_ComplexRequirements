package com.comst.blindapp.domain.repository

import com.comst.blindapp.domain.model.Content

interface ContentRepository {

    suspend fun save(item : Content) : Boolean
}