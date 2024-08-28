package com.pisces.piscesnews.presentation.UnityAds

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.unity3d.services.banners.UnityBannerSize

@Composable
fun UnityBannerAdView(modifier: Modifier = Modifier, placementId: String,activity: Activity) {
    val context = LocalContext.current
    val unityBannerSize = UnityBannerSize(320, 250)

    AndroidView(
        modifier = modifier,
        factory = {
            UnityBannerAd(activity,placementId)
        }
    )
}

