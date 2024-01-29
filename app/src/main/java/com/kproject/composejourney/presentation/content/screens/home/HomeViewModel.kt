package com.kproject.composejourney.presentation.content.screens.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {
    private var _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    fun onUiEvent(event: HomeUiEvent) {
        when (event) {
            is HomeUiEvent.CodeChanged -> {
                _uiState.update { it.copy(code = event.code) }
            }
            is HomeUiEvent.CepChanged -> {
                _uiState.update { it.copy(cep = event.cep) }
            }
        }
    }
}