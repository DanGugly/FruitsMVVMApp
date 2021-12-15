package com.example.fruitmvvmapp.di

import dagger.Component
import javax.inject.Singleton

@Component(modules = [
    AppModule::class,
    NetworkModule::class
])
@Singleton
interface FruitComponent {

}