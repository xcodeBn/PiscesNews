package com.pisces.piscesnews.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.pisces.piscesnews.domain.model.Article


@Database(entities = [Article::class], version = 2)
@TypeConverters(NewsTypeConverter::class)
abstract class PiscesNewsDataBase:RoomDatabase() {

    abstract val newsDao:NewsDao
}