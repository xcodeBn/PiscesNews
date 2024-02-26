package com.pisces.piscesnews.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.pisces.piscesnews.domain.model.Article
import com.pisces.piscesnews.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
private val newsUseCases: NewsUseCases
):ViewModel() {


            var news = newsUseCases.getNews( sources = listOf("bbc-news","abc-news","al-jazeera-english"))




}