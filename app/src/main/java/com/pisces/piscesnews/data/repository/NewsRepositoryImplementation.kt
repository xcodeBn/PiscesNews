package com.pisces.piscesnews.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.pisces.piscesnews.data.remote.NewsApi
import com.pisces.piscesnews.data.remote.NewsPagingSource
import com.pisces.piscesnews.domain.model.Article
import com.pisces.piscesnews.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImplementation(
    private val newsApi: NewsApi
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


}