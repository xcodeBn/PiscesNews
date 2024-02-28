package com.pisces.piscesnews.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.pisces.piscesnews.domain.model.Source


@ProvidedTypeConverter
class NewsTypeConverter {

    @TypeConverter
    fun sourceToString(source: Source):String{
        return "${source.id},${source.name}"
    }

    @TypeConverter
    fun StringToSource(source: String):Source{
        return source.split(",").let{
            sourceArray->
            Source(sourceArray[0],sourceArray[1])
        }
    }
}