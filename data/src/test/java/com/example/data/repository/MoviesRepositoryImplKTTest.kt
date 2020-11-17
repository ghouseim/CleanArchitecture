package com.example.data.repository

import com.example.data.networking.MoviesApi
import com.example.data.networking.model.MovieEntity
import com.nhaarman.mockito_kotlin.given
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MoviesRepositoryImplKTTest {

    @Mock
    private lateinit var moviesApi: MoviesApi

    @Mock
    private lateinit var moviesResponse: Response<List<MovieEntity>>


    @Test
    fun `test sample`() {
        runBlocking {
            given(moviesResponse.body()).willReturn(null)
            given(moviesResponse.isSuccessful).willReturn(true)
            given(moviesApi.movies()).willReturn(moviesResponse)
        }
    }

}