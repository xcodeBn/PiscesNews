package com.pisces.piscesnews.presentation.details.components

import com.pisces.piscesnews.domain.model.Article

sealed class DetailsEvent {

    data class UpsertDeleteArticle(val article: Article) : DetailsEvent()
    object RemoveSideEffect : DetailsEvent()

}