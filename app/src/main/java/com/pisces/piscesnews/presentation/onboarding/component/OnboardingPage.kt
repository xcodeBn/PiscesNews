package com.pisces.piscesnews.presentation.onboarding.component

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pisces.piscesnews.R
import com.pisces.piscesnews.presentation.Dimens
import com.pisces.piscesnews.presentation.onboarding.Page
import com.pisces.piscesnews.presentation.onboarding.pages
import com.pisces.piscesnews.ui.theme.PiscesNewsTheme

@Composable
fun OnboardingPage(
    modifier: Modifier=Modifier,
    page: Page
) {
    Column(modifier= modifier) {
        Image(modifier=Modifier
            .fillMaxWidth()
            .fillMaxHeight(fraction = 0.6f),
            painter = painterResource(id = page.image),
            contentDescription = null,
            contentScale = ContentScale.Crop)

        Spacer(modifier = Modifier.height(Dimens.MediumPadding1))
        Text(
            text = page.title,
            modifier = Modifier.padding(horizontal = Dimens.MediumPadding2),
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.display_small),
        )

        Text(
            text = page.description,
            modifier = Modifier.padding(horizontal =Dimens.MediumPadding2),
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.text_medium),
        )
    }
    

}


@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun TestOnboarding() {
    PiscesNewsTheme {

        OnboardingPage(page = pages[0])

    }
}