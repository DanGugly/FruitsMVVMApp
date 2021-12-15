package com.example.fruitmvvmapp.rest

import com.example.fruitmvvmapp.model.Fruits
import com.example.fruitmvvmapp.model.FruitsItem
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkApi
{
    /* RxJava implementation

    @GET(ALL_FRUITS)
    fun retrieveAllFruits(): Single<Fruits>

    @GET(SEARCH_FRUIT)
    fun searchFruit(@Path("fruitId") fruitName : String) : Single<FruitsItem>

     */

    @GET(ALL_FRUITS)
    suspend fun retrieveAllFruits(): Response<Fruits>

    @GET(SEARCH_FRUIT)
    suspend fun searchFruit(@Path("fruitId") fruitName: String): Response<FruitsItem>

    companion object{
        const val BASE_URL = "https://www.fruityvice.com/"
        private const val ALL_FRUITS = "api/fruit/all"
        private const val SEARCH_FRUIT = "api/fruit/{fruitId}"
    }
}