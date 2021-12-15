package com.example.fruitmvvmapp.model


import com.squareup.moshi.Json

data class Nutritions(
    @Json(name = "calories")
    val calories: Int,
    @Json(name = "carbohydrates")
    val carbohydrates: Int,
    @Json(name = "fat")
    val fat: Double,
    @Json(name = "protein")
    val protein: Double,
    @Json(name = "sugar")
    val sugar: Int
)