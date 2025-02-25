package com.example.weatherapp.responseModel


import com.google.gson.annotations.SerializedName

data class CloudsX(
    @SerializedName("all")
    val all: Int
)