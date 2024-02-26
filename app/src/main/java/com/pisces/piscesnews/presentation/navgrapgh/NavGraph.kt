package com.pisces.piscesnews.presentation.navgrapgh

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.paging.compose.collectAsLazyPagingItems
import com.pisces.piscesnews.presentation.home.HomeScreen
import com.pisces.piscesnews.presentation.home.HomeViewModel
import com.pisces.piscesnews.presentation.onboarding.OnBoardingScreen
import com.pisces.piscesnews.presentation.onboarding.OnBoardingViewModel

@Composable
fun NavGraph(
    startDestination:String
) {
    val navController = rememberNavController()
    val onBoardingViewModel: OnBoardingViewModel = hiltViewModel()
    val homeViewModel:HomeViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = startDestination){

        navigation(
            route=Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ){
            composable(route=Route.OnBoardingScreen.route){
                OnBoardingScreen(onBoardingViewModel::onEvent)
            }
        }

        navigation(route=Route.NewsNavigator.route,
            startDestination=Route.NewsNavigatorScreen.route){
            composable(route= Route.NewsNavigatorScreen.route){
                val articles = homeViewModel.news.collectAsLazyPagingItems()
                HomeScreen(articles = articles, navigate ={} )
                println("Tetttttt $articles")
            }
        }

    }
}