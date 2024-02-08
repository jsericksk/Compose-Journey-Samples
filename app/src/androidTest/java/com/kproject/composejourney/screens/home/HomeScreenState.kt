package com.kproject.composejourney.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.kproject.composejourney.presentation.content.screens.home.HomeUiEvent
import com.kproject.composejourney.presentation.content.screens.home.HomeUiState

class HomeScreenState {
    var uiState: HomeUiState by mutableStateOf(HomeUiState())
        private set

    fun onUiEvent(event: HomeUiEvent) {
        uiState = when (event) {
            is HomeUiEvent.CodeChanged -> {
                uiState.copy(code = event.code)
            }
            is HomeUiEvent.CepChanged -> {
                uiState.copy(cep = event.cep)
            }
        }
    }
}

@Composable
fun rememberHomeScreenState(): HomeScreenState {
    return remember { HomeScreenState() }
}