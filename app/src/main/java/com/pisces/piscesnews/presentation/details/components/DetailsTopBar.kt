package com.pisces.piscesnews.presentation.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.pisces.piscesnews.R
import com.pisces.piscesnews.ui.theme.PiscesNewsTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsTopBar(
    onBrowsingClick:()->Unit,
    onShareClick:()->Unit,
    onBookmarkClick:()->Unit,
    onBackClicked:()->Unit,
    isBookmarked:Boolean
) {

    val color = MaterialTheme.colorScheme.primary


   val  bookMarkTint = if (isBookmarked)
        MaterialTheme.colorScheme.primary
    else Color.Gray
    TopAppBar(
        title = { },
        modifier = Modifier.fillMaxWidth(),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            actionIconContentColor = colorResource(id = R.color.body),
            navigationIconContentColor = colorResource(id = R.color.body)
        ),
        navigationIcon = {
            IconButton(onClick = onBackClicked) {
                Icon(painter = painterResource(id = R.drawable.ic_back_arrow), contentDescription = null )
            }
        },
        actions = {

            IconButton(onClick = onBookmarkClick) {
                Icon(painter = painterResource(id = R.drawable.ic_bookmark), contentDescription = null,
                    tint = bookMarkTint , modifier = Modifier.clickable {


                        println("BookMark Color: ${isBookmarked}")
                    })
            }
            IconButton(onClick = onShareClick) {
                Icon(imageVector = Icons.Default.Share, contentDescription = null )
            }
            IconButton(onClick = onBrowsingClick) {
                Icon(painter = painterResource(id = R.drawable.ic_network), contentDescription = null )
            }
        }

    )
}


