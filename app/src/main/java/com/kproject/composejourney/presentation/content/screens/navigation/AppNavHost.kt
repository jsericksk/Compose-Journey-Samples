package com.kproject.composejourney.presentation.content.screens.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kproject.composejourney.presentation.content.screens.home.HomeScreen
import com.kproject.composejourney.presentation.content.screens.tracking.TrackingScreen

private const val ANIMATION_DURATION = 700

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        // HomeScreen
        composable(
            route = Screen.HomeScreen.route
        ) { navBackStackEntry ->
            HomeScreen(
                onNavigateToTracking = { code, cep ->
                    if (navBackStackEntry.canNavigate()) {
                        navController.navigate(
                            Screen.TrackingScreen.routeWithArgs(code, cep)
                        )
                    }
                },
            )
        }

        /*
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
        ) { navBackStackEntry ->
            navBackStackEntry.arguments?.let { bundle ->
                TrackingScreen(
                    code = bundle.getString(TRACKING_CODE) ?: "",
                    cep = bundle.getInt(TRACKING_CEP),
                    onNavigateBack = { navController.popBackStack() }
                )
            }
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
            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Up,
                    animationSpec = tween(durationMillis = ANIMATION_DURATION)
                )
            },
            popExitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Down,
                    animationSpec = tween(durationMillis = ANIMATION_DURATION)
                )
            }
        ) { navBackStackEntry ->
            TrackingScreen(
                onNavigateBack = {
                    if (navBackStackEntry.canNavigate()) {
                        navController.popBackStack()
                    }
                }
            )
        }
    }
}

private fun NavBackStackEntry.canNavigate() =
        this.lifecycle.currentState == Lifecycle.State.RESUMED