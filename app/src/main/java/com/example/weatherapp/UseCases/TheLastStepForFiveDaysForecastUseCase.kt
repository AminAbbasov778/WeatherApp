package com.example.weatherapp.UseCases

import com.example.weatherapp.responseModel.AverageForecast
import com.example.weatherapp.responseModel.HourlyForecastResponse
import javax.inject.Inject

class TheLastStepForFiveDaysForecastUseCase @Inject constructor() {
    fun getfinalfivedaysforecast(hourlyforecast: HourlyForecastResponse,collector: UseCaseCollector) : ArrayList<AverageForecast>{
        var averageForecastsOfDayUseCase = collector.averageForecastsOfDayUseCase
        var map =averageForecastsOfDayUseCase.findaverageforecastsofdays(hourlyforecast,collector)

        var finallist = ArrayList<AverageForecast>()
        for(key in map.keys){
            map[key]?.let {
                finallist.add(map[key]!!)
            }

        }

        return finallist


    }
}