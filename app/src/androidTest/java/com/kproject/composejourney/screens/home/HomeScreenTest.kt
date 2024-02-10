package com.kproject.composejourney.screens.home

import androidx.activity.ComponentActivity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTextReplacement
import com.kproject.composejourney.R
import com.kproject.composejourney.presentation.content.screens.home.HomeContent
import com.kproject.composejourney.presentation.content.screens.home.HomeUiEvent
import com.kproject.composejourney.presentation.content.screens.home.HomeUiState
import com.kproject.composejourney.presentation.theme.MyAppTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private lateinit var tracker: String
    private lateinit var trackingCode: String
    private lateinit var cep: String
    private lateinit var track: String

    @Before
    fun setUp() {
        composeTestRule.activity.apply {
            tracker = getString(R.string.tracker)
            trackingCode = getString(R.string.tracking_code)
            cep = getString(R.string.cep)
            track = getString(R.string.track)
        }
    }

    @Test
    fun homeScreenIsDisplayedCorrectly() {
        val myCode = "AMZ123456789"
        val myCep = 123456
        composeTestRule.setContent {
            MyAppTheme {
                HomeContent(
                    uiState = HomeUiState(code = myCode, cep = myCep),
                    onUiEvent = {},
                    onNavigateToTracking = {}
                )
            }
        }

        composeTestRule.onNodeWithText(tracker).assertIsDisplayed()
        composeTestRule.onNodeWithText(trackingCode).assertIsDisplayed()
        composeTestRule.onNodeWithText(cep).assertIsDisplayed()
        composeTestRule.onNodeWithText(track).assertIsDisplayed()

        composeTestRule.onNodeWithText(myCode).assertIsDisplayed()
        composeTestRule.onNodeWithText(myCep.toString()).assertIsDisplayed()
    }

    @Test
    fun whenTrackingDataIsNotEmpty_thenTrackButtonShouldBeEnabled() {
        composeTestRule.setContent {
            MyAppTheme {
                HomeContent(
                    uiState = HomeUiState(code = "AMZ123456", cep = 123456),
                    onUiEvent = {},
                    onNavigateToTracking = {}
                )
            }
        }

        composeTestRule.onNodeWithText(track).assertIsEnabled()
    }

    @Test
    fun whenTrackingDataIsEmpty_thenTrackButtonShouldBeDisabled() {
        composeTestRule.setContent {
            MyAppTheme {
                HomeContent(
                    uiState = HomeUiState(code = "", cep = -1),
                    onUiEvent = {},
                    onNavigateToTracking = {}
                )
            }
        }

        composeTestRule.onNodeWithText(track).assertIsNotEnabled()
    }

    @Test
    fun whenTypingNonNumberCharactersInTheCep_thenTextFieldShouldIgnore() {
        composeTestRule.setContent {
            MyAppTheme {
                var homeUiState: HomeUiState by remember { mutableStateOf(HomeUiState()) }
                HomeContent(
                    uiState = homeUiState,
                    onUiEvent = { event ->
                        homeUiState = when (event) {
                            is HomeUiEvent.CodeChanged -> homeUiState.copy(code = event.code)
                            is HomeUiEvent.CepChanged -> homeUiState.copy(cep = event.cep)
                        }
                    },
                    onNavigateToTracking = {}
                )
            }
        }

        val invalidCep1 = "abcdef"
        composeTestRule.onNodeWithText(cep).performTextInput(invalidCep1)
        composeTestRule.onNodeWithText(invalidCep1).assertIsNotDisplayed()

        val invalidCep2 = "-,.{}/@#"
        composeTestRule.onNodeWithText(cep).performTextInput(invalidCep2)
        composeTestRule.onNodeWithText(invalidCep2).assertIsNotDisplayed()

        val invalidCep3 = " "
        composeTestRule.onNodeWithText(cep).performTextInput(invalidCep3)
        composeTestRule.onNodeWithText(invalidCep3).assertIsNotDisplayed()

        val validCep1 = "1"
        composeTestRule.onNodeWithText(cep).performTextInput(validCep1)
        composeTestRule.onNodeWithText(validCep1).assertIsDisplayed()

        val validCep2 = "23456"
        composeTestRule.onNodeWithText(cep).performTextInput(validCep2)
        composeTestRule.onNodeWithText(validCep1 + validCep2).assertIsDisplayed()

        val validCep3 = "abc"
        composeTestRule.onNodeWithText(cep).performTextInput(validCep3)
        composeTestRule.onNodeWithText(validCep2 + validCep3).assertIsNotDisplayed()
        composeTestRule.onNodeWithText(validCep1 + validCep2).assertIsDisplayed()
    }

    @Test
    fun whenInsertCodeAndCep_thenEnableTrackButton() {
        composeTestRule.setContent {
            MyAppTheme {
                var homeUiState: HomeUiState by remember { mutableStateOf(HomeUiState()) }
                HomeContent(
                    uiState = homeUiState,
                    onUiEvent = { event ->
                        homeUiState = when (event) {
                            is HomeUiEvent.CodeChanged -> homeUiState.copy(code = event.code)
                            is HomeUiEvent.CepChanged -> homeUiState.copy(cep = event.cep)
                        }
                    },
                    onNavigateToTracking = {}
                )
            }
        }

        composeTestRule.onNodeWithText(track).assertIsNotEnabled()
        composeTestRule.onNodeWithText(trackingCode).performTextInput("AMZ123456")
        composeTestRule.onNodeWithText(track).assertIsNotEnabled()

        composeTestRule.onNodeWithText(cep).performTextInput("123456")
        composeTestRule.onNodeWithText(track).assertIsEnabled()

        composeTestRule.onNodeWithText(trackingCode).performTextReplacement("")
        composeTestRule.onNodeWithText(track).assertIsNotEnabled()
    }
}