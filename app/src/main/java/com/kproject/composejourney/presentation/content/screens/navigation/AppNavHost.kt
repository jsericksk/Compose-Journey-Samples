package com.kproject.composejourney.presentation.content.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kproject.composejourney.presentation.content.screens.profile.ProfileScreen
import com.kproject.composejourney.presentation.content.screens.register.RegisterScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.RegisterScreen.route
    ) {
        // RegisterScreen
        composable(route = Screen.RegisterScreen.route) {
            RegisterScreen(
                onNavigateToProfile = { email ->
                    navController.navigate(Screen.ProfileScreen.routeWithArgs(email))
                },
            )
        }

        // ProfileScreen
        composable(route = Screen.ProfileScreen.route) { navBackStackEntry ->
            ProfileScreen(
                email = "",
            )
        }
    }
}
