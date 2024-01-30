package com.kamilagcabay.movieappcleanarchitecture.Presentation.movies.views

sealed class MoviesEvent {
    data class Search(val searchString:String) : MoviesEvent()
}