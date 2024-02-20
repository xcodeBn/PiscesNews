package com.pisces.piscesnews.data.remote.dto

import com.pisces.piscesnews.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)