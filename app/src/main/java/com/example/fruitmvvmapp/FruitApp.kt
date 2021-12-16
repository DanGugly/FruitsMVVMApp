package com.example.fruitmvvmapp

import android.app.Application
import com.example.fruitmvvmapp.di.AppModule
import com.example.fruitmvvmapp.di.DaggerFruitComponent
import com.example.fruitmvvmapp.di.FruitComponent
import com.example.fruitmvvmapp.di.koin.networkModule
import com.example.fruitmvvmapp.di.koin.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class FruitApp : Application() {
    override fun onCreate() {
        super.onCreate()

        fruitComponent = DaggerFruitComponent.builder()
            .appModule(AppModule(this))
            .build()
        /**
         * Here the project is started without needed to build the project first
         */
        startKoin {
            // Logs data into logcat for KOIN (OPTIONAL)
            androidLogger(Level.DEBUG)
            //Provides and injects context when needed
            androidContext(this@FruitApp)
            //Modules that KOIN will take to provide and inject the objects
            modules(listOf(networkModule, viewModelModule))
        }
    }

    companion object{
        lateinit var fruitComponent: FruitComponent
    }
}