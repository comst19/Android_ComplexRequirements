package com.umc.mediasearchapp.repository

import android.database.Observable
import com.umc.mediasearchapp.SearchService
import com.umc.mediasearchapp.model.ListItem

class SearchRepositoryImpl(private val searchService: SearchService) : SearchRepository {

    override fun search(query: String): Observable<List<ListItem>> {
        return searchService.searchImage(query)
    }
}