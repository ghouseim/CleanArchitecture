package com.example.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactor.GetMovies
import com.example.domain.model.Movie
import com.example.domain.model.onFailure
import com.example.domain.model.onSuccess
import com.example.presentation.viewstate.MovieView
import kotlinx.coroutines.launch


class MoviesViewModel(
    private val getMovies: GetMovies
) : ViewModel() {

    var movies: MutableLiveData<List<MovieView>> = MutableLiveData()

    fun loadMovies() {
        viewModelScope.launch {
            getMovies(Unit).onSuccess {
                Log.e("Movies", "Success")
                handleMovieList(it)
            }
                .onFailure {
                    Log.e("Movies", "Failure")
                }
        }
    }

    private fun handleMovieList(movies: List<Movie>) {
        this.movies.value = movies.map {
            MovieView(it.id, it.poster)
        }
    }
}