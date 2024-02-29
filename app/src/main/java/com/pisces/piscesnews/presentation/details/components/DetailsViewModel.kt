package com.pisces.piscesnews.presentation.details.components

import androidx.compose.runtime.MutableState
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

        var isSaved: MutableState<Boolean> = mutableStateOf(false)
        var sideEffect  by mutableStateOf<String?>(null)
            private set


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
        isSaved.value = false
        newsUseCases.deleteArticle(article)
        sideEffect ="Article Deleted!"

    }

    private suspend fun upsertArticle(article: Article) {

        isSaved.value = true
        newsUseCases.upsertArticle(article)
        sideEffect ="Article Saved!"

    }


}