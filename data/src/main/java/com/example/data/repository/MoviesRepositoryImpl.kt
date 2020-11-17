package com.example.data.repository

import com.example.data.networking.GENERAL_NETWORK_ERROR
import com.example.data.networking.MoviesApi
import com.example.data.networking.MoviesService
import com.example.domain.model.*
import com.example.domain.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesRepositoryImpl(
    private val moviesApi: MoviesApi
) : MoviesRepository.Remote {

    override suspend fun movies(): Result<List<Movie>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = moviesApi.movies()
                if (response.isSuccessful) {
                    Success(response.body()?.map { it.toMovie() } ?: emptyList())
                } else {
                    Failure(HttpError(Throwable(GENERAL_NETWORK_ERROR)))
                }
            } catch (t: Throwable) {
                Failure(HttpError(Throwable(GENERAL_NETWORK_ERROR)))
            }
        }

    }
}
