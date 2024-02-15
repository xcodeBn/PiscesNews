package com.pisces.piscesnews.presentation.onboarding

import androidx.annotation.DrawableRes
import com.pisces.piscesnews.R

data class Page(
    val title:String,
    val description:String,
    @DrawableRes val image: Int
)


val pages = listOf<Page>(
    Page(
        "Welcome",
        "Lorem ipsum is simply dummy text of the printing and typesetting inddustry",
        R.drawable.onboarding1
    ),
    Page(
        "Lorem ipsum is simply dummy",
        "get news here",
        R.drawable.onboarding2
    ),
    Page(
        "bla bla",
        "Lorem ipsum is simply dummy text of the printing and typesetting inddustry",
        R.drawable.onboarding3
    ),
)