package com.pisces.piscesnews.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.google.gson.Gson
import com.pisces.piscesnews.data.local.NewsDao
import com.pisces.piscesnews.data.local.NewsTypeConverter
import com.pisces.piscesnews.data.local.PiscesNewsDataBase
import com.pisces.piscesnews.data.manager.LocalUserManagerImplementation
import com.pisces.piscesnews.data.remote.NewsApi
import com.pisces.piscesnews.data.repository.NewsRepositoryImplementation
import com.pisces.piscesnews.domain.manager.LocalUserManager
import com.pisces.piscesnews.domain.repository.NewsRepository
import com.pisces.piscesnews.domain.usecases.app_entry.AppEntryUseCases
import com.pisces.piscesnews.domain.usecases.app_entry.ReadAppEntry
import com.pisces.piscesnews.domain.usecases.app_entry.SaveAppEntry
import com.pisces.piscesnews.domain.usecases.news.DeleteArticle
import com.pisces.piscesnews.domain.usecases.news.GetNews
import com.pisces.piscesnews.domain.usecases.news.IsBookmarked
import com.pisces.piscesnews.domain.usecases.news.NewsUseCases
import com.pisces.piscesnews.domain.usecases.news.SearchNews
import com.pisces.piscesnews.domain.usecases.news.SelectArticle
import com.pisces.piscesnews.domain.usecases.news.SelectArticles
import com.pisces.piscesnews.domain.usecases.news.UpsertArticle
import com.pisces.piscesnews.util.Constants.BASE_URL
import com.pisces.piscesnews.util.Constants.NEWS_DATABASE_NAME
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
    fun provideNewsRepository(newsApi: NewsApi,newsDao: NewsDao):NewsRepository= NewsRepositoryImplementation(newsApi = newsApi, newsDao = newsDao )
    @Provides
    @Singleton
    fun provideNewsUsecases(newsRepository: NewsRepository):NewsUseCases = NewsUseCases(
        getNews = GetNews(newsRepository),
        searchNews = SearchNews(newsRepository),
        selectArticles = SelectArticles(newsRepository),
        deleteArticle = DeleteArticle(newsRepository),
        upsertArticle = UpsertArticle(newsRepository),
        selectArticle = SelectArticle(newsRepository),
        isBookmarked = IsBookmarked(newsRepository)
    )


    @Provides
    @Singleton
    fun provideNewsDataBase(
        application: Application
    ):PiscesNewsDataBase {
        return Room.databaseBuilder(
            context = application,
            klass = PiscesNewsDataBase::class.java,
            name = NEWS_DATABASE_NAME
        ).addTypeConverter(NewsTypeConverter()).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideNewsDoa(
        newsDataBase: PiscesNewsDataBase
    )= newsDataBase.newsDao


}