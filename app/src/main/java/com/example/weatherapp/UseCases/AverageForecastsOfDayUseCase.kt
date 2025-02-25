package com.example.weatherapp.UseCases

import com.example.weatherapp.responseModel.AverageForecast
import com.example.weatherapp.responseModel.HourlyForecastResponse
import javax.inject.Inject

class AverageForecastsOfDayUseCase @Inject constructor() {
    fun findaverageforecastsofdays(hourlyforecast: HourlyForecastResponse,collector: UseCaseCollector): MutableMap<String, AverageForecast> {
        var sumAverageDataUseCase = collector.sumAverageDataUseCase
        var fiveDaysHourlyForecastToMapUseCase= collector.fiveDaysHourlyForecastToMapUseCase
        var dateListUseCase = collector.dateListUseCase
        var hourlyforecastmap =fiveDaysHourlyForecastToMapUseCase.addfivedayshourlyforecasttomap(hourlyforecast,collector)

        var averageforecastdatas = mutableMapOf<String, AverageForecast>()


        if (!hourlyforecastmap.keys.isNullOrEmpty()) {
            var datelist =dateListUseCase.getdatelist(hourlyforecast,collector)
            for ((key,fulldate) in hourlyforecastmap.keys.zip(datelist)) {

                var list = hourlyforecastmap[key]
                list?.let {

                    averageforecastdatas[key] =sumAverageDataUseCase.sumaveragedata(list,fulldate, collector )
                }


            }
        }


        return averageforecastdatas

    }


}