package com.pisces.piscesnews.presentation.details.components

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pisces.piscesnews.domain.model.Article
import com.pisces.piscesnews.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel
    @Inject constructor( private val newsUseCases: NewsUseCases):ViewModel() {

        private val _state = mutableStateOf(DetailsState())
        var state:State<DetailsState> = _state
        var sideEffect  by mutableStateOf<String?>(null)
            private set



    fun articleStuff(article: Article){
        _state.value = state.value.copy(article=article)
        viewModelScope.launch {
            if(isBookmarked(url = article.url))
                _state.value = state.value.copy(isBookmarked = true)
            else
                _state.value = state.value.copy(isBookmarked = false)
        }
    }





    fun onEvent(event:DetailsEvent){


        when(event){
            is DetailsEvent.UpsertDeleteArticle ->{
                viewModelScope.launch {
                    val article = newsUseCases.selectArticle(event.article.url)

                    if(article==null){
                        upsertArticle(event.article)
                        _state.value = state.value.copy(isBookmarked = true)
                    }
                    else{
                        deleteArticle(article)
                        _state.value = state.value.copy(isBookmarked = false)

                    }
                }

            }
            is DetailsEvent.RemoveSideEffect->{
                sideEffect = null
            }


        }
    }

    private suspend fun deleteArticle(article: Article) {
        newsUseCases.deleteArticle(article)
        sideEffect ="Article Deleted!"
        _state.value = state.value.copy(isBookmarked = false)

    }

    private suspend fun upsertArticle(article: Article) {

        newsUseCases.upsertArticle(article)
        sideEffect ="Article Saved!"
        _state.value = state.value.copy(isBookmarked = true)

    }


     suspend fun isBookmarked(url:String): Boolean {
        return newsUseCases.isBookmarked(url)
    }


}