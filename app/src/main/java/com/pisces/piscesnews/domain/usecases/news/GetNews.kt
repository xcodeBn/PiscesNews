package com.pisces.piscesnews.domain.usecases.news

import androidx.paging.PagingData
import com.pisces.piscesnews.domain.model.Article
import com.pisces.piscesnews.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {

      operator fun invoke(sources:List<String>):Flow<PagingData<Article>>{

        return newsRepository.getNews(sources)
    }
}