package com.pisces.piscesnews.domain.repository

import androidx.paging.PagingData
import com.pisces.piscesnews.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(sources:List<String>): Flow<PagingData<Article>>

    fun searchNews(sources: List<String>,searchQuery:String):Flow<PagingData<Article>>
}