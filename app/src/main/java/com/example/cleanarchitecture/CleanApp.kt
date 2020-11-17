package com.example.cleanarchitecture

import android.app.Application

import com.example.data.di.networkingModule
import com.example.data.di.repositoryModule
import com.example.domain.di.interactionModule
import com.example.presentation.di.appModule
import com.example.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CleanApp : Application() {
  
  companion object {
    lateinit var instance: Application
      private set
  }
  
  override fun onCreate() {
    super.onCreate()
    instance = this
    
    startKoin {
      androidContext(this@CleanApp)
//      if (BuildConfig.DEBUG) androidLogger(Level.DEBUG)
      modules(appModules + domainModules + dataModules)
    }
  }
}

val appModules = listOf(presentationModule, appModule)
val domainModules = listOf(interactionModule)
val dataModules = listOf(networkingModule, repositoryModule)
