package com.kproject.composejourney.presentation.content.screens.register

data class RegisterUiState(
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val address: String = ""
)

sealed class RegisterUiEvent {
    data class UsernameChanged(val username: String) : RegisterUiEvent()
    data class EmailChanged(val email: String) : RegisterUiEvent()
    data class PasswordChanged(val password: String) : RegisterUiEvent()
    data class AddressChanged(val address: String) : RegisterUiEvent()
}