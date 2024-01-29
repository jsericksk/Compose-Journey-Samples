package com.kproject.composejourney.presentation.content.screens.tracking

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TrackingViewModel : ViewModel() {
    private var _uiState = MutableStateFlow(TrackingUiState())
    val uiState = _uiState.asStateFlow()

    fun getTrackingInfo(
        code: String,
        cep: Int
    ) {
        viewModelScope.launch {
            delay(2500)
            _uiState.update {
                it.copy(
                    viewState = ViewState.Success,
                    code = code,
                    cep = cep
                )
            }
        }
    }
}