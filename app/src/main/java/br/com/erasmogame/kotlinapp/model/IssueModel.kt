package br.com.erasmogame.kotlinapp.model

import com.google.gson.annotations.SerializedName

data class IssueModel (

    @SerializedName("url") val url : String,
    @SerializedName("title") val title : String,
    @SerializedName("user") val user : UserModel,
    @SerializedName("state") val state : String,
    @SerializedName("created_at") val created_at : String,
    @SerializedName("body") val description : String
)

