package com.pisces.piscesnews.presentation.common

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.pisces.piscesnews.R
import com.pisces.piscesnews.domain.model.Article
import com.pisces.piscesnews.domain.model.Source
import com.pisces.piscesnews.presentation.Dimens.ArticleCardSize
import com.pisces.piscesnews.presentation.Dimens.ExtraSmallPadding
import com.pisces.piscesnews.presentation.Dimens.ExtraSmallPadding2
import com.pisces.piscesnews.presentation.Dimens.SmallIconSize
import com.pisces.piscesnews.ui.theme.PiscesNewsTheme

@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onClick: ()->Unit
) {

    val context = LocalContext.current
    Row(modifier= modifier.clickable { onClick() }) {

        AsyncImage(
            modifier = Modifier
                .size(ArticleCardSize)
                .clip(MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(context).data(article.urlToImage).build(),
            contentDescription = null,
            contentScale = ContentScale.Crop

        )

        Column(
            modifier = Modifier
                .padding(horizontal = ExtraSmallPadding)
                .height(ArticleCardSize),
            verticalArrangement = Arrangement.SpaceAround
        ) {

            Text(
                text = article.title,
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(
                    id = R.color.text_title
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Row (verticalAlignment = Alignment.CenterVertically){
                Text(
                    text = article.source.name,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(
                        id = R.color.text_title
                    )
                )
                Spacer(modifier = Modifier.width(ExtraSmallPadding2))
                Icon(
                    modifier = Modifier.size(SmallIconSize),
                    tint = colorResource(id = R.color.body),
                    painter = painterResource(id = R.drawable.ic_time),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(ExtraSmallPadding2))

                Text(
                    text = article.extractAndFormatTimestamp(),
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(
                        id = R.color.text_title
                    )
                )


            }
        }
    }
}


@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ArticlePreview() {
PiscesNewsTheme {
    Surface(){
        val article = Article(
            author = "John Doe",
            content = "Some content",
            description = "Some description",
            publishedAt = "2024-08-28T12:34:56Z",
            source = Source("example","sa"),
            title = "Some title",
            url = "https://example.com",
            urlToImage = "https://example.com/image.jpg"
        )
        ArticleCard(
            article = article
        ) {

        }
    }

}
}