package com.umc.mediasearchapp.repository

import android.database.Observable
import com.umc.mediasearchapp.model.ListItem

interface SearchRepository {
    fun search(query : String) : Observable<List<ListItem>>
}