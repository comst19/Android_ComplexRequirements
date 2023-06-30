package com.example.shoppingmall.remote.repository

import androidx.paging.PagingData
import com.example.shoppingmall.model.ListItem
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    fun loadList() : Flow<PagingData<ListItem>>
}