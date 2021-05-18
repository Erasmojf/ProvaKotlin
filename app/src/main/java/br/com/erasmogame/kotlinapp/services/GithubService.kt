package br.com.erasmogame.kotlinapp.services

import br.com.erasmogame.kotlinapp.model.IssueModel
import retrofit2.Call
import retrofit2.http.GET

interface GithubService {

    @GET("issues")
    fun getDataFromAPI(): Call<List<IssueModel>>?
}