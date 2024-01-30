package com.kproject.composejourney.presentation.content.screens.tracking

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TrackingViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(TrackingUiState())
    val uiState: StateFlow<TrackingUiState> = _uiState.asStateFlow()

    fun getTrackingInfo(
        code: String,
        cep: Int
    ) {
        _uiState.update { it.copy(code = code, cep = cep) }
    }
}

/**
class TrackingViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _uiState = MutableStateFlow(TrackingUiState())
    val uiState: StateFlow<TrackingUiState> = _uiState.asStateFlow()

    init {
        _uiState.update {
            it.copy(
                code = savedStateHandle.get<String>(TRACKING_CODE) ?: "",
                cep = savedStateHandle.get<Int>(TRACKING_CEP) ?: -1,
            )
        }
    }
}*/