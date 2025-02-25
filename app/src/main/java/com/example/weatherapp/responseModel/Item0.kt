package com.example.weatherapp.responseModel


import com.google.gson.annotations.SerializedName

data class Item0(
    @SerializedName("clouds")
    val clouds: CloudsX,
    @SerializedName("dt")
    val dt: Int,
    @SerializedName("dt_txt")
    val dtTxt: String,
    @SerializedName("main")
    val main: MainX,
    @SerializedName("pop")
    val pop: Double,
    @SerializedName("rain")
    val rain: Rain? = Rain(0.0),
    @SerializedName("sys")
    val sys: SysX,
    @SerializedName("visibility")
    val visibility: Int,
    @SerializedName("weather")
    val weather: List<WeatherX>,
    @SerializedName("wind")
    val wind: WindX,
    val time : String,
)