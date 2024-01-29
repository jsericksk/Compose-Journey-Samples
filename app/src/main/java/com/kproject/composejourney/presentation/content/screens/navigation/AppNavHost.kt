package com.kproject.composejourney.presentation.content.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kproject.composejourney.presentation.content.screens.home.HomeScreen
import com.kproject.composejourney.presentation.content.screens.tracking.TrackingScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        // HomeScreen
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(
                onNavigateToTracking = { code, cep ->
                    navController.navigate(
                        Screen.TrackingScreen.routeWithArgs(code, cep)
                    )
                },
            )
        }

        // TrackingScreen
        /*composable(
            route = Screen.TrackingScreen.route,
            arguments = listOf(
                navArgument(name = TRACKING_CODE) {
                    type = NavType.StringType
                },
                navArgument(name = TRACKING_CEP) {
                    type = NavType.IntType
                }
            ),
        ) { navBackStackEntry ->
            TrackingScreen(
                code = navBackStackEntry.arguments!!.getString(TRACKING_CODE)!!,
                cep = navBackStackEntry.arguments!!.getInt(TRACKING_CEP),
                onNavigateBack = { navController.popBackStack() }
            )
        }*/

        // TrackingScreen
        composable(
            route = Screen.TrackingScreen.route,
            arguments = listOf(
                navArgument(name = TRACKING_CODE) {
                    type = NavType.StringType
                },
                navArgument(name = TRACKING_CEP) {
                    type = NavType.IntType
                }
            ),
        ) {
            TrackingScreen(onNavigateBack = { navController.popBackStack() })
        }
    }
}