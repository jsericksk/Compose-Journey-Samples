package com.kproject.composejourney.navigation

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.kproject.composejourney.R
import com.kproject.composejourney.presentation.content.screens.navigation.AppNavHost
import com.kproject.composejourney.presentation.content.screens.navigation.Screen
import com.kproject.composejourney.presentation.theme.MyAppTheme
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NavigationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private lateinit var navController: TestNavHostController

    @Before
    fun setUpAppNavHost() {
        composeTestRule.setContent {
            MyAppTheme {
                navController = TestNavHostController(LocalContext.current)
                navController.navigatorProvider.addNavigator(ComposeNavigator())
                AppNavHost(navController = navController)
            }
        }
    }

    @Test
    fun verifyStartDestination() {
        composeTestRule.onNodeWithText(getString(R.string.tracker)).assertIsDisplayed()
    }

    @Test
    fun whenClickOnTrackButton_thenShouldNavigateToTrackingScreen() {
        val currentRoute1 = navController.currentBackStackEntry?.destination?.route
        assertEquals(currentRoute1, Screen.HomeScreen.route)
        composeTestRule
            .onNodeWithText(getString(R.string.tracker))
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText(getString(R.string.tracking_code))
            .performTextInput("AMZ123456")
        composeTestRule
            .onNodeWithText(getString(R.string.cep))
            .performTextInput("123456789")
        composeTestRule
            .onNodeWithText(getString(R.string.track))
            .performClick()

        val currentRoute2 = navController.currentBackStackEntry?.destination?.route
        assertEquals(currentRoute2, Screen.TrackingScreen.route)
        composeTestRule
            .onNodeWithText(getString(R.string.tracking))
            .assertIsDisplayed()
    }

    private fun getString(resourceId: Int) = composeTestRule.activity.getString(resourceId)
}