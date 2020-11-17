package com.example.data.networking

import com.example.data.networking.model.MovieEntity
import retrofit2.Response
import retrofit2.http.GET

interface MoviesApi {
    companion object {
        private const val MOVIES = "movies.json"
    }

    @GET(MOVIES)
    suspend fun movies(): Response<List<MovieEntity>>
}
