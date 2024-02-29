package com.pisces.piscesnews.domain.usecases.news

import com.pisces.piscesnews.data.local.NewsDao
import com.pisces.piscesnews.domain.model.Article
import com.pisces.piscesnews.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles(
    private val newsRepository: NewsRepository
) {
     operator fun invoke(): Flow<List<Article>> {

        return newsRepository.selectArticles()
    }
}