package com.pisces.piscesnews.presentation.bookmark

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import com.pisces.piscesnews.R
import com.pisces.piscesnews.domain.model.Article
import com.pisces.piscesnews.presentation.Dimens.MediumPadding1
import com.pisces.piscesnews.presentation.common.ArticlesList
import com.pisces.piscesnews.presentation.common.EmptyScreen
import com.pisces.piscesnews.presentation.navgrapgh.Route


@Composable
fun BookmarkScreen(
    state: BookMarkState,
    navigateToDetails: (Article)->Unit
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .statusBarsPadding()
        .padding(
            top = MediumPadding1,
            end = MediumPadding1,
            start = MediumPadding1
        )) {
        Text(text = "Bookmark", style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.text_title))

        Spacer(modifier = Modifier.height(MediumPadding1))
        if(state.articles.size==0){
            EmptyScreen()
        }
        ArticlesList(articles = state.articles, onClick ={
            navigateToDetails(it)
        })
    }
}