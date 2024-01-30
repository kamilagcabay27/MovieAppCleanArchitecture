package com.kamilagcabay.movieappcleanarchitecture.Presentation.movies.views

import com.kamilagcabay.movieappcleanarchitecture.Domain.Model.Movie

data class MoviesState (
    val isLoading : Boolean = false,
    val movies : List<Movie> = emptyList(),
    val error :String = "",
    val search : String = "Flash",
)