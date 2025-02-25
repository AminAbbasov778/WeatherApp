package com.example.weatherapp.responseModel

data class AverageForecast(
    var averagewindspeeds: Double,
    var averagetemps: Int,
    var averagemintemps: Int,
    var averagemaxtemps: Int,
    var averagefeelsliketemps: Int,
    var averagehumiditypercentages: Int,
    var averagepressure: Int,
    var iconurl : String,
    var date : String,
)