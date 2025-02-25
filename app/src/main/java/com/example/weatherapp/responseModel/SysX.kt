package com.example.weatherapp.responseModel


import com.google.gson.annotations.SerializedName

data class SysX(
    @SerializedName("pod")
    val pod: String
)