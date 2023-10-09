package com.example.favoritecity.data

data class AppUiState(
    val categoryChosen: SmallDetail? = null,
    val placeChosen: SmallDetail? = null,
    val isShowingStartScreen: Boolean = true
)
