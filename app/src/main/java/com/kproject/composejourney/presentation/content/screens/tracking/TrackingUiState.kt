package com.kproject.composejourney.presentation.content.screens.tracking

data class TrackingUiState(
    val viewState: ViewState = ViewState.Loading,
    val code: String = "",
    val cep: Int = 0
)

enum class ViewState {
    Loading,
    Success,
    Error
}