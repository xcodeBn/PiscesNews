package com.pisces.piscesnews.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pisces.piscesnews.presentation.Dimens.MediumPadding2
import com.pisces.piscesnews.presentation.Dimens.PageIndicatorWidth
import com.pisces.piscesnews.presentation.common.NewsButton
import com.pisces.piscesnews.presentation.common.NewsTextButton
import com.pisces.piscesnews.presentation.common.PageIndicator
import com.pisces.piscesnews.presentation.onboarding.component.OnboardingPage
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen() {
    Column(modifier = Modifier.fillMaxSize()) {

        val pagerState = rememberPagerState(initialPage = 0) {
            pages.size
        }

        val buttonState = remember {
            derivedStateOf {
                when(pagerState.currentPage){
                    0 -> listOf("","Next")
                pages.size-1 -> listOf("Back","Welcome")

                    else -> listOf("Back","Next")
                }
            }
        }

        HorizontalPager(state = pagerState) {
            index ->
            OnboardingPage(page = pages[index])
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = MediumPadding2)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){

            PageIndicator(
                modifier = Modifier.width(PageIndicatorWidth),
                pageSize = pages.size,
                selectedPage = pagerState.currentPage
            )

            val scope = rememberCoroutineScope()
            Row(verticalAlignment = Alignment.CenterVertically) {
                if(buttonState.value[0].isNotEmpty()){

                    NewsTextButton(text = buttonState.value[0], onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(page= pagerState.currentPage - 1)

                        }
                    })
                }
            }

            NewsButton(text = buttonState.value[1]) {
                scope.launch {
                    if (pagerState.currentPage== pages.size-1){
                        // TODO: navigate to homescreen
                    }
                    else{
                        pagerState.animateScrollToPage(page = pagerState.currentPage +1)
                    }
                }
            }
            
        }
        
        Spacer(modifier = Modifier.weight(0.5f))
    }
}