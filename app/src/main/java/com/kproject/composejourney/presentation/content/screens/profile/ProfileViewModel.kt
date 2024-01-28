package com.kproject.composejourney.presentation.content.screens.profile

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProfileViewModel : ViewModel() {
    private var _uiState = MutableStateFlow(ProfileUiState())
    val uiState = _uiState.asStateFlow()


}