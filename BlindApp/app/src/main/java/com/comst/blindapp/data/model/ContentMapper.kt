package com.comst.blindapp.data.model

import com.comst.blindapp.data.dto.ContentDto
import com.comst.blindapp.data.model.entitiy.ContentEntity
import com.comst.blindapp.domain.model.Content
import java.util.Date

object ContentMapper {

    fun Content.toRequest() = ContentDto(
        id = id,
        title = title,
        content = content,
        category = category,
        likeCount = likeCount,
        commentCount = commentCount,
        viewCount = viewCount
    )

    fun Content.toEntity() = ContentEntity(
        id = id ?: -1,
        title = title,
        content = content,
        category = category,
        likeCount = likeCount,
        commentCount = commentCount,
        viewCount = viewCount,
        createdDate = createdDate ?: Date()
    )

    fun ContentDto.toContent() = Content(
        id = id ?: -1,
        title = title,
        content = content,
        category = category,
        likeCount = likeCount ?: 0,
        viewCount = viewCount ?: 0,
        commentCount = commentCount ?: 0,
        createdDate = createdDate ?: Date()
    )

    fun ContentEntity.toContent() = Content(
        id = id,
        title = title,
        content = content,
        category = category,
        viewCount = viewCount,
        commentCount = commentCount,
        likeCount = likeCount,
        createdDate = createdDate
    )

    fun ContentDto.toEntity() = ContentEntity(
        id = id ?: -1,
        title = title,
        content = content,
        category = category,
        likeCount = likeCount ?: 0,
        commentCount = commentCount ?: 0,
        viewCount = viewCount ?: 0,
        createdDate = createdDate ?: Date()
    )
}