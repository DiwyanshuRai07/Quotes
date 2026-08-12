package com.quotes.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.quotes.presentation.screens.detailScreen.DetailsScreen
import com.quotes.presentation.screens.homeScreen.HomeScreen

@Composable
fun AppNavController() {
    val navController = rememberNavController()

    NavHost(
        navController = navController, startDestination = ScreenName.HOME_SCREEN
    ) {

        composable(route = ScreenName.HOME_SCREEN) {
            HomeScreen(
                onclick = {id ->
                    navController.navigate(ScreenName.DETAIL_SCREEN + "/$id")
                }
            )
        }

        composable(route = ScreenName.DETAIL_SCREEN + "/{id}", arguments =
        listOf(
            navArgument(name = "id"){
                type = NavType.StringType
            }
        )) {
            DetailsScreen{
                navController.popBackStack()
            }
        }
    }
}
