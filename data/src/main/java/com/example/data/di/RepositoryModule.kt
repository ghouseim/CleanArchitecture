package com.example.data.di

import com.example.data.common.utils.Connectivity
import com.example.data.common.utils.ConnectivityImpl
import com.example.data.networking.MoviesService
import com.example.data.repository.MoviesRepositoryImpl
import com.example.domain.repository.MoviesRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    factory<MoviesRepository.Remote> { MoviesRepositoryImpl(get()) }
    factory { MoviesService(get()) }
    factory<Connectivity> { ConnectivityImpl(androidContext()) }
}