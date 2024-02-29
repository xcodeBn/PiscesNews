package com.pisces.piscesnews.domain.usecases.news

data class NewsUseCases(
   val getNews: GetNews,
   val searchNews: SearchNews,
   val selectArticles: SelectArticles,
   val deleteArticle: DeleteArticle,
   val upsertArticle: UpsertArticle,
   val selectArticle: SelectArticle

)
