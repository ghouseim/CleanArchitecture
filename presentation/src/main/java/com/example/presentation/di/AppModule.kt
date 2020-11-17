package com.example.presentation.di

import com.example.data.common.coroutine.CoroutineContextProvider
import org.koin.dsl.module

val appModule = module {
    single { CoroutineContextProvider() }
}