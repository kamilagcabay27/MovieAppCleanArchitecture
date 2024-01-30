package com.kamilagcabay.movieappcleanarchitecture.Presentation.movie_detail.views

import androidx.compose.runtime.Recomposer
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kamilagcabay.movieappcleanarchitecture.Domain.Use_Case.get_movie_detail.GetMovieDetailsUseCase
import com.kamilagcabay.movieappcleanarchitecture.Util.Constants.IMDB_ID
import com.kamilagcabay.movieappcleanarchitecture.Util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    private val stateHandle : SavedStateHandle
) : ViewModel(){

    private val _state = mutableStateOf<MovieDetailState>(MovieDetailState())

    val state : State<MovieDetailState> = _state

    init {

        stateHandle.get<String>(IMDB_ID)?.let {
            getMovieDetail(it)
        }

    }

    private fun getMovieDetail(imdbId : String) {
        getMovieDetailsUseCase.executeGetMovieDetails(imdbId).onEach {
            when(it) {
                is Resource.Success -> {
                    _state.value = MovieDetailState(movie = it.data)
                }

                is Resource.Loading -> {
                    _state.value = MovieDetailState(isLoading = true)

                }

                is Resource.Error -> {
                    _state.value = MovieDetailState(error = it.message ?: "Error!!")

                }

            }
        }.launchIn(viewModelScope)
    }


}