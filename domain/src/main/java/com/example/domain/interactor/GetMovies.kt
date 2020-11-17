package com.example.domain.interactor

import com.example.domain.base.BaseUseCase
import com.example.domain.model.Movie
import com.example.domain.model.Result
import com.example.domain.repository.MoviesRepository

class GetMovies(
    private val moviesRepository: MoviesRepository.Remote
) : BaseUseCase<Unit, List<Movie>> {

    override suspend fun invoke(param: Unit): Result<List<Movie>> {
        return moviesRepository.movies()
    }
}
