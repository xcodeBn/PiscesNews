package com.pisces.piscesnews.presentation.search

import androidx.paging.PagingData
import com.pisces.piscesnews.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery:String = "",
    val articles:Flow<PagingData<Article>> ?= null
)