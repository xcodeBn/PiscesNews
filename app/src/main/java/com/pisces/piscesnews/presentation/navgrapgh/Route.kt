package com.pisces.piscesnews.presentation.navgrapgh

sealed class Route(val route:String) {

    object OnBoardingScreen:Route(route = "OnBoardingScreen")
    object HomeScreen:Route(route = "HomeScreen")
    object SearchScreen:Route(route = "SearchScreen")
    object BookmarkScreen:Route(route = "bookmarkScreen")
    object DetailScreen:Route(route = "DetailScreen")

    object AppStartNavigation:Route(route = "AppStartNavigation")
    object NewsNavigation:Route(route = "NewsNavigation")

    object NewsNavigationScreen:Route(route = "NewsNavigationScreen")



}