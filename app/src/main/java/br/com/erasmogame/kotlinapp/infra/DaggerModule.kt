package br.com.erasmogame.kotlinapp.infra

import br.com.erasmogame.kotlinapp.services.GithubService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DaggerModule {
    val baseUrl = "https://api.github.com/repos/JetBrains/kotlin/issues"

    @Singleton
    @Provides
    fun getRetroServiceInterface(retrofit: Retrofit) : GithubService {
         return retrofit.create(GithubService::class.java)
    }
    @Singleton
    @Provides
    fun getRetroFitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}