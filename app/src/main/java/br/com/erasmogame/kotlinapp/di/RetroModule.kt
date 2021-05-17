package br.com.erasmogame.kotlinapp.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetroModule {
    val baseUrl = "https://api.github.com/repos/JetBrains/kotlin/issues"

    @Singleton
    @Provides
    fun getRetroServiceInterface(retrofit: Retrofit) : RetroServiceInterface {
         return retrofit.create(RetroServiceInterface:: class.java)
    }
    @Singleton
    @Provides
    fun  getRetroFitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}