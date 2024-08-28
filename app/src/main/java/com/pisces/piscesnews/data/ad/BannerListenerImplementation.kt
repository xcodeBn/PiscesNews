package com.pisces.piscesnews.data.ad

import android.util.Log
import com.unity3d.services.banners.BannerErrorInfo
import com.unity3d.services.banners.BannerView

class BannerListenerImplementation: BannerView.IListener {
   companion object{
       private const val TAG = "BannerListenerImplement"
   }

    override fun onBannerLoaded(bannerAdView: BannerView?) {
        Log.d(TAG, "onBannerLoaded: Banner loaded")
        bannerAdView?.load()
    }

    override fun onBannerShown(bannerAdView: BannerView?) {

    }

    override fun onBannerClick(bannerAdView: BannerView?) {


    }

    override fun onBannerFailedToLoad(bannerAdView: BannerView?, errorInfo: BannerErrorInfo?) {
        Log.e(TAG, "onBannerFailedToLoad: ")

    }

    override fun onBannerLeftApplication(bannerView: BannerView?) {
    }
}