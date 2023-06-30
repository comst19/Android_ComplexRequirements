package com.example.shoppingmall.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.shoppingmall.model.ListItem
import com.example.shoppingmall.remote.MainPageingSource
import com.example.shoppingmall.remote.MainService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainService : MainService
) : MainRepository{
    override fun loadList() = Pager(
        config = PagingConfig(
            pageSize = 20,
            enablePlaceholders = false
        ),
        pagingSourceFactory = {
            MainPageingSource(mainService)
        }
    ).flow
}