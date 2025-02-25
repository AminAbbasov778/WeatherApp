package com.example.weatherapp.responseModel


import com.google.gson.annotations.SerializedName

data class WindX(
    @SerializedName("deg")
    val deg: Int,
    @SerializedName("gust")
    val gust: Double,
    @SerializedName("speed")
    val speed: Double
)