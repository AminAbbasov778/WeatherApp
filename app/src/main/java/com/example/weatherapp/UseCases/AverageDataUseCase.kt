package com.example.weatherapp.UseCases

import com.example.weatherapp.responseModel.AverageForecast
import com.example.weatherapp.responseModel.Item0
import javax.inject.Inject

class AverageDataUseCase @Inject constructor( ) {

    fun sumaveragedata(hourlyforecast: ArrayList<Item0>, fulldate : String,collector: UseCaseCollector): AverageForecast {
        var iconUrlUseCase = collector.iconUrlUseCase
        var roundUseCase = collector.roundUseCase
        var wayThatFindTheMostUsedIconUseCase = collector.wayThatFindTheMostUsedIconUseCase
        if (hourlyforecast.isEmpty()) {

            return AverageForecast(0.0, 0, 0, 0, 0, 0, 0,"empty","empty")

        }
        var averagetempDouble =
            hourlyforecast.sumOf { it.main.temp } / hourlyforecast.size
        var averagetempInt =roundUseCase.roundedtemp(averagetempDouble)
        var averagemintempDouble =
            hourlyforecast.sumOf { it.main.tempMin } / hourlyforecast.size
        var averagemintempInt = roundUseCase.roundedtemp(averagemintempDouble)
        var averagemaxtempDouble =
            hourlyforecast.sumOf { it.main.tempMax } / hourlyforecast.size
        var averagemaxtempInt = roundUseCase.roundedtemp(averagemaxtempDouble)
        var averagefeelsliketempDouble =
            hourlyforecast.sumOf { it.main.feelsLike } / hourlyforecast.size
        var averagefeelsliketempInt =roundUseCase.roundedtemp(averagefeelsliketempDouble)
        var averagehumidity =
            hourlyforecast.sumOf { it.main.humidity } / hourlyforecast.size
        var averagewindspeed =
            hourlyforecast.sumOf { it.wind.speed } / hourlyforecast.size

        var averagepressure =
            hourlyforecast.sumOf { it.main.pressure } / hourlyforecast.size
        var iconurl =iconUrlUseCase.geticonurl(wayThatFindTheMostUsedIconUseCase.waythatfindthemostusedicon(hourlyforecast))



        if(fulldate.isNotEmpty()){
            return AverageForecast(
                averagewindspeed,
                averagetempInt,
                averagemintempInt,
                averagemaxtempInt,
                averagefeelsliketempInt,
                averagehumidity,
                averagepressure,iconurl,fulldate
            )
        }else{
            return AverageForecast(
                averagewindspeed,
                averagetempInt,
                averagemintempInt,
                averagemaxtempInt,
                averagefeelsliketempInt,
                averagehumidity,
                averagepressure,iconurl,"empty")
        }

    }

}