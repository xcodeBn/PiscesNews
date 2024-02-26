package com.pisces.piscesnews.di

import android.app.Application
import com.google.gson.Gson
import com.pisces.piscesnews.data.manager.LocalUserManagerImplementation
import com.pisces.piscesnews.data.remote.NewsApi
import com.pisces.piscesnews.data.repository.NewsRepositoryImplementation
import com.pisces.piscesnews.domain.manager.LocalUserManager
import com.pisces.piscesnews.domain.repository.NewsRepository
import com.pisces.piscesnews.domain.usecases.app_entry.AppEntryUseCases
import com.pisces.piscesnews.domain.usecases.app_entry.ReadAppEntry
import com.pisces.piscesnews.domain.usecases.app_entry.SaveAppEntry
import com.pisces.piscesnews.domain.usecases.news.GetNews
import com.pisces.piscesnews.domain.usecases.news.NewsUseCases
import com.pisces.piscesnews.domain.usecases.news.SearchNews
import com.pisces.piscesnews.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providLocalUserManager(
        application: Application
    ):LocalUserManager = LocalUserManagerImplementation(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(localUserManager:LocalUserManager): AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideApiInstance(): NewsApi {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }



    @Provides
    @Singleton
    fun provideNewsRepository(newsApi: NewsApi):NewsRepository= NewsRepositoryImplementation(newsApi = newsApi )
    @Provides
    @Singleton
    fun provideNewsUsecases(newsRepository: NewsRepository):NewsUseCases = NewsUseCases(
        getNews = GetNews(newsRepository),
        searchNews = SearchNews(newsRepository)
    )


}