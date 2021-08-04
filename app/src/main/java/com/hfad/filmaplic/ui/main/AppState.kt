package com.hfad.filmaplic.ui.main

sealed class AppState{
    data class Success(val filmsData:Any):AppState()
    data class Error(val error:Throwable):AppState()
    object Loading:AppState()
}
