package com.pisces.piscesnews.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.pisces.piscesnews.data.local.NewsDao
import com.pisces.piscesnews.data.remote.NewsApi
import com.pisces.piscesnews.data.remote.NewsPagingSource
import com.pisces.piscesnews.data.remote.SearchNewsPagingSource
import com.pisces.piscesnews.domain.model.Article
import com.pisces.piscesnews.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

class NewsRepositoryImplementation(
    private val newsApi: NewsApi,
    private val newsDao: NewsDao
):NewsRepository {
    override  fun getNews(sources: List<String>): Flow<PagingData<Article>> {

        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi = newsApi,
                    sources = sources.joinToString(",")
                )
            }
        ).flow

    }

    override fun searchNews(sources: List<String>, searchQuery: String): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingSource(
                    api = newsApi,
                    searchQuery=searchQuery,
                    sources = sources.joinToString(",")
                )
            }
        ).flow
    }

    override suspend fun upsertArticle(article: Article) {
       newsDao.upsert(article.copy(isBookmarked=true))
    }

    override suspend fun deleteArticle(article: Article) {
       newsDao.delete(article)
    }

    override fun selectArticles(): Flow<List<Article>> {
        return newsDao.getArticles()
    }

    override suspend fun selectArticle(url: String): Article? {
       return newsDao.getArticle(url)
    }

    override suspend fun isBookmarked(url: String): Boolean {
        return newsDao.getArticle(url)!=null
    }


}