package com.kamilagcabay.movieappcleanarchitecture.Domain.Repository

import com.kamilagcabay.movieappcleanarchitecture.Data.Remote.dto.MovieDetailDto
import com.kamilagcabay.movieappcleanarchitecture.Data.Remote.dto.MoviesDto

interface MovieRepository {

    suspend fun getMovies(search : String) : MoviesDto
    suspend fun getMovieDetail(imdbId : String) : MovieDetailDto
}