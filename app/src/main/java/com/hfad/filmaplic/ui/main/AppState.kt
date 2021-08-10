package com.hfad.filmaplic.ui.main

sealed class AppState {
    data class SuccessList(val filmListArray: List<Film>) : AppState()
    data class Success(val filmList: Film) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}
