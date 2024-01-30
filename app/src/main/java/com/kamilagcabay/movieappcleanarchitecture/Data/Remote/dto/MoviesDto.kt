package com.kamilagcabay.movieappcleanarchitecture.Data.Remote.dto

import com.kamilagcabay.movieappcleanarchitecture.Domain.Model.Movie

data class MoviesDto(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)


fun MoviesDto.toMovieList(): List<Movie> {
    return Search.map {search -> Movie(search.Poster, search.Title, search.Year, search.imdbID) }
}