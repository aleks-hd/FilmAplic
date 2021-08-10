package com.hfad.filmaplic.ui.main

data class Film(val name: String = "koko", var description: String = "описание фильма")


fun getListFilms(): List<Film> {
    return listOf(
        Film("jumla", "opisanie"),
        Film("kadjfn", "opisanie"),
        Film("sdfg", "opisanie"),
        Film("iopyr", "opisanie"),
        Film("sd545fg", "opisanie"),
        Film("dsdfgh", "opisanie"),
        Film("jumla", "opisanie"),
        Film("ertw", "opisanie")
    )
}
