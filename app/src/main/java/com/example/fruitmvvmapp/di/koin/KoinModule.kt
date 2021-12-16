package com.example.fruitmvvmapp.di.koin

import com.example.fruitmvvmapp.rest.NetworkApi
import com.example.fruitmvvmapp.viewmodel.FruitViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * This is our view model module that will be injected by Koin
 * module {} is provided by koin as well as viewmodel {}
 * We just need to provite viewmodel into it
 */
val viewModelModule = module {
    viewModel {
        FruitViewModel(get())
    }
}

/**
 * Provide network interfaces and objects
 */
val networkModule = module {

    fun provideMoshi() = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

    fun provideLoggingInterceptor() = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    fun okHttpClient(loggingInterceptor : HttpLoggingInterceptor) =
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

    fun provideNetworkApi(okHttpClient: OkHttpClient, moshi: Moshi) =
        Retrofit.Builder()
            .baseUrl(NetworkApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient)
            .build()
            .create(NetworkApi::class.java)

    single { provideMoshi() }
    single { provideLoggingInterceptor() }
    single { okHttpClient(get()) }
    single { provideNetworkApi(get(), get()) }
}