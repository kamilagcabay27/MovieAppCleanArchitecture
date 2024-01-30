package com.kamilagcabay.movieappcleanarchitecture.Data.Repository

import com.kamilagcabay.movieappcleanarchitecture.Data.MovieAPI
import com.kamilagcabay.movieappcleanarchitecture.Data.Remote.dto.MovieDetailDto
import com.kamilagcabay.movieappcleanarchitecture.Data.Remote.dto.MoviesDto
import com.kamilagcabay.movieappcleanarchitecture.Domain.Repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val api :MovieAPI) :MovieRepository {
    override suspend fun getMovies(search: String): MoviesDto {
        return api.getMovies(searchString = search)
    }

    override suspend fun getMovieDetail(imdbId: String): MovieDetailDto {

        return api.getMovieDetail(imdbId = imdbId)

    }
}