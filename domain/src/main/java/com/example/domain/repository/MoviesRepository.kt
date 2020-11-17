package com.example.domain.repository

import com.example.domain.model.Movie
import com.example.domain.model.Result

interface MoviesRepository {

    interface Remote {
        suspend fun movies(): Result<List<Movie>>
    }
}
