package com.pisces.piscesnews

import android.app.Application
import com.pisces.piscesnews.util.Constants.UNITY_GAME_ID
import com.unity3d.ads.IUnityAdsInitializationListener
import com.unity3d.ads.UnityAds
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class PiscesNews:Application() {
    private val unityGameID = UNITY_GAME_ID
    private val testMode = true






}