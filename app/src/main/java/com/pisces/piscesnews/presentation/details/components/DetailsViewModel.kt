package com.pisces.piscesnews.presentation.details.components

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pisces.piscesnews.domain.model.Article
import com.pisces.piscesnews.domain.model.Source
import com.pisces.piscesnews.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import java.util.concurrent.Flow
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel
    @Inject constructor( private val newsUseCases: NewsUseCases):ViewModel() {

        private val _state = mutableStateOf(Article("","","","", Source("",""),"","","",false))
        val state:State<Article> = _state
        var sideEffect  by mutableStateOf<String?>(null)
            private set



    init {

    }

    fun observeArticle(article: Article):kotlinx.coroutines.flow.Flow<Article>{
        _state.value = article
        return flow {
            _state.value
        }
    }



    fun onEvent(event:DetailsEvent){


        when(event){
            is DetailsEvent.UpsertDeleteArticle ->{
                viewModelScope.launch {
                    val article = newsUseCases.selectArticle(event.article.url)

                    if(article==null){
                        upsertArticle(event.article)
                    }
                    else{
                        deleteArticle(article)
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
        _state.value = state.value.copy(isBookmarked = false)
        sideEffect ="Article Deleted!"

    }

    private suspend fun upsertArticle(article: Article) {
        newsUseCases.upsertArticle(article)
        sideEffect ="Article Saved!"
        _state.value = state.value.copy(isBookmarked = true)
    }





}