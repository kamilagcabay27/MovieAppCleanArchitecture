package com.kamilagcabay.movieappcleanarchitecture.Data

import com.kamilagcabay.movieappcleanarchitecture.Data.Remote.dto.MovieDetailDto
import com.kamilagcabay.movieappcleanarchitecture.Data.Remote.dto.MoviesDto
import com.kamilagcabay.movieappcleanarchitecture.Util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {


    @GET(".")
    suspend fun getMovies(
        @Query("s") searchString: String,
        @Query("apikey") apiKey : String = API_KEY
    ) : MoviesDto


    @GET(".")
    suspend fun getMovieDetail(
        @Query("i") imdbId: String,
        @Query("apikey") apiKey : String = API_KEY
    ) : MovieDetailDto



}