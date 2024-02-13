package com.pisces.piscesnews.presentation.onboarding

import androidx.annotation.DrawableRes
import com.pisces.piscesnews.R

data class Page(
    val title:String,
    val description:String,
    @DrawableRes val image: Int
)


val pages = listOf(
    Page(title = "Welcome!",
        description = "Pisces news! a portfolio project",
        image = R.drawable.onboarding1
    ),
    Page(title = "Learn about latest news!",
        description = "Latest news here is the most latest latestest to latest the world",
        image = R.drawable.onboarding2)
    ,
    Page(title = "Enjoy the app!",
        description = "it's made for your enjoyment",
        image = R.drawable.onboarding3)
)