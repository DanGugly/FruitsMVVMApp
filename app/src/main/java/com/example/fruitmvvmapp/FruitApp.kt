package com.example.fruitmvvmapp

import android.app.Application
import com.example.fruitmvvmapp.di.AppModule
import com.example.fruitmvvmapp.di.DaggerFruitComponent
import com.example.fruitmvvmapp.di.FruitComponent

class FruitApp : Application() {
    override fun onCreate() {
        super.onCreate()

        fruitComponent = DaggerFruitComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    companion object{
        lateinit var fruitComponent: FruitComponent
    }
}