package com.hfad.filmaplic.ui.main

interface Repository {
    fun getFilmsFromLocal(): Film
}