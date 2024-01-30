package com.kamilagcabay.movieappcleanarchitecture.Presentation.movie_detail.views

import com.kamilagcabay.movieappcleanarchitecture.Domain.Model.MovieDetail

data class MovieDetailState (
    val isLoading : Boolean = false,
    val movie: MovieDetail? = null,
    val error : String = ""
)