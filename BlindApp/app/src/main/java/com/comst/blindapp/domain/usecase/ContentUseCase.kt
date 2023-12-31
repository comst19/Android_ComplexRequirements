package com.comst.blindapp.domain.usecase

import com.comst.blindapp.domain.model.Content
import com.comst.blindapp.domain.repository.ContentRepository
import javax.inject.Inject

class ContentUseCase @Inject constructor(
    private val contentRepository: ContentRepository
) {
    suspend fun save(item : Content) = contentRepository.save(item)
}