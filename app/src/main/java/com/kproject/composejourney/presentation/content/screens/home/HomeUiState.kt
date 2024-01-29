package com.kproject.composejourney.presentation.content.screens.home

const val UndefinedCep = -1

data class HomeUiState(
    val code: String = "",
    val cep: Int = UndefinedCep
) {
    val cepText: String = if (cep == UndefinedCep) "" else cep.toString()
    val canNavigateToTrackingScreen: Boolean = code.isNotBlank() && cepText.isNotBlank()
}

sealed class HomeUiEvent {
    data class CodeChanged(val code: String) : HomeUiEvent()
    data class CepChanged(val cep: Int) : HomeUiEvent()
}