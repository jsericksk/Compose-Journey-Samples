package com.kproject.composejourney.presentation.content.screens.register

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegisterViewModel : ViewModel() {
    private var _uiState: MutableStateFlow<RegisterUiState> = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState.asStateFlow()

    fun onUiEvent(event: RegisterUiEvent) {
        when (event) {
            is RegisterUiEvent.UsernameChanged -> {
                _uiState.update { it.copy(username = event.username) }
            }
            is RegisterUiEvent.EmailChanged -> {
                _uiState.update { it.copy(email = event.email) }
            }
            is RegisterUiEvent.PasswordChanged -> {
                _uiState.update { it.copy(password = event.password) }
            }
            is RegisterUiEvent.AddressChanged -> {
                _uiState.update { it.copy(address = event.address) }
            }
        }
    }
}