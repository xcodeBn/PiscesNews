package com.pisces.piscesnews.presentation.news_navigator.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pisces.piscesnews.R
import com.pisces.piscesnews.presentation.Dimens.ExtraSmallPadding
import com.pisces.piscesnews.presentation.Dimens.IconSize

@Composable
fun NewsButtomNavigation(
    items: List<BottomNavigationItem>,
    selected:Int,
    onItemClick: (Int)->Unit
) {


    BottomAppBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.background,
        tonalElevation = 10.dp,
    ) {
        items.forEachIndexed { index, bottomNavigationItem ->

            NavigationBarItem(selected = index==selected, onClick = { onItemClick(index) }, icon = {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        painter = painterResource(id = bottomNavigationItem.icon),
                        contentDescription = null,
                        modifier = Modifier.size(IconSize)
                    )
                    Spacer(modifier = Modifier.height(ExtraSmallPadding))
                    Text(text = bottomNavigationItem.text, style = MaterialTheme.typography.labelSmall)
                }

            },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = colorResource(id = R.color.body),
                    unselectedTextColor = colorResource(id = R.color.body),
                    indicatorColor = MaterialTheme.colorScheme.background
                ))

        }
    }
}

@Preview
@Composable
fun previewNews() {
    val items = listOf<BottomNavigationItem>(
        BottomNavigationItem(icon = R.drawable.ic_home,"Home"),
        BottomNavigationItem(icon = R.drawable.ic_search,"Search"),
        BottomNavigationItem(icon = R.drawable.ic_bookmark,"Bookmark")
    )
    NewsButtomNavigation(items = items, selected = 0 , onItemClick = {})
}

data class BottomNavigationItem(
    @DrawableRes val icon:Int,
    val text:String
)