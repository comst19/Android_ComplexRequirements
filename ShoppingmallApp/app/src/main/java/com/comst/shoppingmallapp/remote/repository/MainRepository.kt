package com.comst.shoppingmallapp.remote.repository

import androidx.paging.PagingData
import com.comst.shoppingmallapp.model.ListItem
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    fun loadList() : Flow<PagingData<ListItem>>
}