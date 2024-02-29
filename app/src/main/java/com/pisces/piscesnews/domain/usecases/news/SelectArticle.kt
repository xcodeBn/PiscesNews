package com.pisces.piscesnews.domain.usecases.news

import com.pisces.piscesnews.data.local.NewsDao
import com.pisces.piscesnews.domain.model.Article
import com.pisces.piscesnews.domain.repository.NewsRepository

class SelectArticle(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(url: String): Article? {

      return  newsRepository.selectArticle(url=url)
    }
}