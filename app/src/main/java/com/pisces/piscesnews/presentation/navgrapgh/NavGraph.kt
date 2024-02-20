package com.pisces.piscesnews.presentation.navgrapgh

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation

@Composable
fun NavGraph(
    startDestination:String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination){

        navigation(
            route=Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ){
            composable(route=Route.OnBoardingScreen.route){

            }
        }
    }
}