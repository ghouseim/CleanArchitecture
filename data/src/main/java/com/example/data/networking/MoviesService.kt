package com.example.data.networking

import retrofit2.Retrofit

class MoviesService(retrofit: Retrofit) : MoviesApi {
    private val moviesApi by lazy { retrofit.create(MoviesApi::class.java) }

    override suspend fun movies() = moviesApi.movies()
}
