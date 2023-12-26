package com.comst.shoppingmall.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.comst.shoppingmall.model.ListItem
import com.comst.shoppingmall.remote.MainPagingSource
import com.comst.shoppingmall.remote.MainService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainService: MainService
) : MainRepository {
    override fun loadList() = Pager(
        config = PagingConfig(
            pageSize = 20,
            enablePlaceholders = false
        ),
        pagingSourceFactory = {
            MainPagingSource(mainService)
        }
    ).flow
}