package com.example.domain.di

import com.example.domain.interactor.GetMovies
import org.koin.dsl.module

val interactionModule = module {
  factory { GetMovies(get()) }
}
