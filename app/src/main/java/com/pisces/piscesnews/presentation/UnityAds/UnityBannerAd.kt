package com.pisces.piscesnews.presentation.UnityAds

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.widget.FrameLayout
import android.widget.RelativeLayout
import com.pisces.piscesnews.data.ad.BannerListenerImplementation
import com.unity3d.services.banners.BannerView
import com.unity3d.services.banners.UnityBannerSize

@SuppressLint("ViewConstructor")
class UnityBannerAd(activity: Activity, private val placementId: String) : RelativeLayout(activity) {
    init {
        val bannerView = BannerView(activity, placementId, UnityBannerSize(320, 250))
        bannerView.listener = BannerListenerImplementation()
        addView(bannerView)
    }
}