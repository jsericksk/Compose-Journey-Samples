package com.kproject.composejourney.presentation.content.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kproject.composejourney.presentation.content.screens.home.HomeScreen

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
        composable(route = Screen.TrackingScreen.route) { navBackStackEntry ->

        }
    }
}