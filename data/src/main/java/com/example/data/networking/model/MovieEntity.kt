package com.example.data.networking.model

import com.example.domain.model.Movie

data class MovieEntity(private val id: Int, private val poster: String) {
    fun toMovie() = Movie(id, poster)
}
