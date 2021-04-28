package com.example.daggerscopeapp.api

import android.util.Log
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        Log.d("ModuleTag:", "new ${ApiService::class.simpleName}")
        return ApiService()
    }
}