package com.kproject.composejourney.presentation.content.screens.profile

import com.kproject.composejourney.R

data class ProfileUiState(
    val viewState: ViewState = ViewState.Loading,
    val email: String = "",
    val username: String = "",
    val profileImage: Int = R.drawable.img_car
)

enum class ViewState {
    Loading,
    Success,
    Error
}