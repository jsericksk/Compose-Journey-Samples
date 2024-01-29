package com.kproject.composejourney.presentation.content.screens.navigation

const val TRACKING_CODE = "tracking_code"
const val TRACKING_CEP = "tracking_cep"

sealed class Screen(val route: String) {
    data object HomeScreen : Screen("home_screen")
    data object TrackingScreen : Screen(
        "tracking_screen/{$TRACKING_CODE}/{$TRACKING_CEP}"
    ) {
        fun routeWithArgs(code: String, cep: Int) = "tracking_screen/$code/$cep"
    }
}