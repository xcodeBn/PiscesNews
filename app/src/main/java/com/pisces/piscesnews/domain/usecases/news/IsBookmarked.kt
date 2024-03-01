package com.pisces.piscesnews.domain.usecases.news

import com.pisces.piscesnews.domain.repository.NewsRepository

class IsBookmarked(private val newsRepository: NewsRepository) {

    suspend operator fun invoke(url:String): Boolean {
        return newsRepository.isBookmarked(url)
    }
}