package com.kamilagcabay.movieappcleanarchitecture.Domain.Use_Case.get_movies

import android.net.http.HttpException
import com.kamilagcabay.movieappcleanarchitecture.Data.Remote.dto.toMovieList
import com.kamilagcabay.movieappcleanarchitecture.Domain.Model.Movie
import com.kamilagcabay.movieappcleanarchitecture.Domain.Repository.MovieRepository
import com.kamilagcabay.movieappcleanarchitecture.Util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOError
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val repository: MovieRepository) {
    fun executeGetMovies(search :String) : Flow<Resource<List<Movie>>> = flow{
        try {
            emit(Resource.Loading())
            val movieList = repository.getMovies(search)
            if (movieList.Response.equals("True")) {
                emit(Resource.Success(movieList.toMovieList()))
            } else {
                emit(Resource.Error(message = "No Movie Found!"))
            }
        } catch (e : IOError) {
            emit(Resource.Error(message = "No Internet Connection"))
        }
    }
}