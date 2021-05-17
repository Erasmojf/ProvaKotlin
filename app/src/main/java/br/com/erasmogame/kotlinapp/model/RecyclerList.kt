package br.com.erasmogame.kotlinapp.model

data class RecyclerList(val items: List<RecyclerData>)
data class RecyclerData(val title: String?,
                        val user: User?,
                        val labels: List<String>,
                        val state: String?,
                        )

data class User(val avatar_url: String?,)