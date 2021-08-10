package com.hfad.filmaplic.ui.main

class RepositoryImpl :Repository {
    override fun getFilmsFromLocal(): Film {
       return Film()
    }

    override fun getListFilm(): List<Film> {
       return getListFilms()
    }
}