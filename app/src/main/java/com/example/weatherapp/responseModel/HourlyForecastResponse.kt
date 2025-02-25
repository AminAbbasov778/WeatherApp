package com.example.weatherapp.responseModel


import com.google.gson.annotations.SerializedName

data class HourlyForecastResponse(
    @SerializedName("city")
    val city: City,
    @SerializedName("cnt")
    val cnt: Int,
    @SerializedName("cod")
    val cod: String,
    @SerializedName("list")
    val list: List<Item0>,
    @SerializedName("message")
    val message: Int
)