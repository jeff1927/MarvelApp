package com.apps.marvelapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HeroesApp: Application() {
    override fun onCreate() {
        super.onCreate()

    }
}