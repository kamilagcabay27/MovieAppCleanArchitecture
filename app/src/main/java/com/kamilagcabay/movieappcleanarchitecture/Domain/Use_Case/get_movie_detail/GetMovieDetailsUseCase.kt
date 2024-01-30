package com.kamilagcabay.movieappcleanarchitecture.Domain.Use_Case.get_movie_detail

import com.kamilagcabay.movieappcleanarchitecture.Data.Remote.dto.toMovieDetail
import com.kamilagcabay.movieappcleanarchitecture.Data.Remote.dto.toMovieList
import com.kamilagcabay.movieappcleanarchitecture.Domain.Model.Movie
import com.kamilagcabay.movieappcleanarchitecture.Domain.Model.MovieDetail
import com.kamilagcabay.movieappcleanarchitecture.Domain.Repository.MovieRepository
import com.kamilagcabay.movieappcleanarchitecture.Util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOError
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(private val repository: MovieRepository) {
    fun executeGetMovieDetails(imdbId :String) : Flow<Resource<MovieDetail>> = flow{
        try {
            emit(Resource.Loading())
            val movieDetail = repository.getMovieDetail(imdbId = imdbId)
            emit(Resource.Success(movieDetail.toMovieDetail()))
        } catch (e : IOError) {
            emit(Resource.Error(message = "No Internet Connection"))
        }
    }
}