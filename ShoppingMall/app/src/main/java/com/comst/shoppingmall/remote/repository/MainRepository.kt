package com.comst.shoppingmall.remote.repository

import androidx.paging.PagingData
import com.comst.shoppingmall.model.ListItem
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    fun loadList() : Flow<PagingData<ListItem>>
}