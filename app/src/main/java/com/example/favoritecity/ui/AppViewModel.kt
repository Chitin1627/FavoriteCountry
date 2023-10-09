package com.example.favoritecity.ui

import androidx.lifecycle.ViewModel
import com.example.favoritecity.data.AppUiState
import com.example.favoritecity.data.SmallDetail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AppViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(AppUiState())

    val uiState: StateFlow<AppUiState> = _uiState.asStateFlow()

    fun updateCategory(newCategory: SmallDetail) {
        _uiState.update {currentState ->
            currentState.copy(
                categoryChosen = newCategory
            )
        }
    }

    fun updatePlace(newPlace: SmallDetail) {
        _uiState.update { currentState->
            currentState.copy(
                placeChosen = newPlace
            )
        }
    }

    fun updateStartScreenBool(value: Boolean) {
        _uiState.update {currentState ->
            currentState.copy(
                isShowingStartScreen = value
            )
        }
    }
}