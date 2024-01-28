package com.kproject.composejourney.presentation.content.screens.navigation

const val PROFILE_EMAIL = "profile_email"

sealed class Screen(val route: String) {
    data object RegisterScreen : Screen("register_screen")
    data object ProfileScreen : Screen("profile_screen/{$PROFILE_EMAIL}") {
        fun routeWithArgs(email: String) = "profile_screen/$email"
    }
}