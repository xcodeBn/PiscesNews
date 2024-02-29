package com.pisces.piscesnews.presentation.bookmark

import com.pisces.piscesnews.domain.model.Article

data class BookMarkState(val articles: List<Article> = emptyList())