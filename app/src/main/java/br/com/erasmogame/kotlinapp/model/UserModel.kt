package br.com.erasmogame.kotlinapp.model

import com.google.gson.annotations.SerializedName

data class UserModel (

    @SerializedName("avatar_url") val avatar_url : String
)