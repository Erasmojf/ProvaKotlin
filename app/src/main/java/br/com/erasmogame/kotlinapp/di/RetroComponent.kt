package br.com.erasmogame.kotlinapp.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetroModule::class])
class RetroComponent {
}