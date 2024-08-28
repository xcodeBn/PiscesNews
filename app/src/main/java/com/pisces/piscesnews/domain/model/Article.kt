package com.pisces.piscesnews.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone


@Parcelize
@Entity
data class Article(
    val author: String?,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    @PrimaryKey val url: String,
    val urlToImage: String,
    val isBookmarked: Boolean = false
) : Parcelable {

    fun extractAndFormatTimestamp(): String {
        // Define the expected timestamp format in the input string
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        inputFormat.timeZone = TimeZone.getTimeZone("UTC")

        // Define the output format: "time hours minutes, date dd/MM/yyyy"
        val outputFormat = SimpleDateFormat("HH:mm, dd/MM/yyyy", Locale.getDefault())
        outputFormat.timeZone = TimeZone.getDefault()

        return try {
            // Parse the publishedAt timestamp and convert it to the desired format
            val date = inputFormat.parse(publishedAt)
            date?.let { outputFormat.format(it) } ?: fallbackToPublishedAt()
        } catch (e: Exception) {
            // Return the value of publishedAt with time portion removed if parsing fails
            fallbackToPublishedAt()
        }
    }

    private fun fallbackToPublishedAt(): String {
        // Return the publishedAt value with everything after the date removed
        return publishedAt.substringBefore('T')
    }
}