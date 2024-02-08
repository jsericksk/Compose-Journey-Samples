package com.kproject.composejourney.screens.home

import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.kproject.composejourney.presentation.content.screens.home.HomeContent
import com.kproject.composejourney.presentation.content.screens.home.HomeViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    // use createAndroidComposeRule<YourActivity>() if you need access to
    // an activity

    private lateinit var homeViewModel: HomeViewModel

    @Before
    fun setUp() {
        homeViewModel = HomeViewModel()
    }

    @Test
    fun myTest() {
        composeTestRule.setContent {
            val homeScreenState = rememberHomeScreenState()
            HomeContent(
                uiState = homeScreenState.uiState,
                onUiEvent = homeScreenState::onUiEvent,
                onNavigateToTracking = {}
            )
        }

        composeTestRule.onNodeWithText("CEP").performTextInput("12345689")
        composeTestRule.onNodeWithText("CEP").assertTextContains("12345689")
    }
}