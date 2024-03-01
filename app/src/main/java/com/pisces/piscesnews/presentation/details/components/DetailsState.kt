package com.pisces.piscesnews.presentation.details.components

import com.pisces.piscesnews.domain.model.Article
import com.pisces.piscesnews.domain.model.Source

data class DetailsState(
    var isBookmarked:Boolean = false,
    var article: Article = Article("","","","", Source("",""),"","","")
)
