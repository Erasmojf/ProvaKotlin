package br.com.erasmogame.kotlinapp

import android.app.Application
import br.com.erasmogame.kotlinapp.di.RetroComponent
import br.com.erasmogame.kotlinapp.di.RetroModule

class MyApplication: Application() {

    private lateinit var retroComponent: RetroComponent

    override fun onCreate() {
        super.onCreate()
//         retroComponent = DaggerRetroComponent.builder()
//             .retroModule(RetroModule())
//             .build()
    }

    fun  getRetroComponent() : RetroComponent {
        return  retroComponent
    }
}