package com.pisces.piscesnews.domain.usecases.news

import androidx.paging.PagingData
import com.pisces.piscesnews.domain.model.Article
import com.pisces.piscesnews.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SearchNews(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(searchQuery:String,sources:List<String>): Flow<PagingData<Article>> {

        return newsRepository.searchNews(sources = sources,searchQuery=searchQuery)
    }
}