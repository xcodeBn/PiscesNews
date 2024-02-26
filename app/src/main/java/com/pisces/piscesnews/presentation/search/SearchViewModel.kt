package com.pisces.piscesnews.presentation.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.pisces.piscesnews.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases,
):ViewModel() {

    private val _state = mutableStateOf(SearchState())
    val state: State<SearchState> = _state
    fun onEvent(event: SearchEvent){
        when (event) {
            is SearchEvent.SearchNews -> {
                searchNews()
            }

            is SearchEvent.UpdateSearchQuery ->{
                _state.value = state.value.copy(searchQuery = event.searchQuery)
            }
            else ->{

            }
        }
    }

    private fun searchNews() {
        val searchQuery = state.value.searchQuery
        val articles = newsUseCases.searchNews(
            searchQuery = searchQuery,
            sources = listOf("bbc-news","abc-news","al-jazeera-english")
        ).cachedIn(viewModelScope)
        _state.value = state.value.copy(articles=articles)
    }
}