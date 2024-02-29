package com.pisces.piscesnews.domain.usecases.news

import com.pisces.piscesnews.data.local.NewsDao
import com.pisces.piscesnews.domain.model.Article
import com.pisces.piscesnews.domain.repository.NewsRepository

class DeleteArticle(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(article: Article){

        newsRepository.deleteArticle(article)
    }
}