package com.example.weatherapp.UseCases

import com.example.weatherapp.responseModel.AverageForecast
import com.example.weatherapp.responseModel.HourlyForecastResponse
import javax.inject.Inject

class AverageTomorrowForecastUseCase @Inject constructor() {
    fun getaveragetomorrowforecast(hourlyforecast: HourlyForecastResponse,collector: UseCaseCollector): AverageForecast {
        var tomorrowHourlyForecastListUseCase = collector.tomorrowHourlyForecastListUseCase
        var sumAverageDataUseCase = collector.sumAverageDataUseCase
        var hourlytomorrowforecastlist =tomorrowHourlyForecastListUseCase.gettomorrowhourlyforecastlist(hourlyforecast,collector)

        return sumAverageDataUseCase.sumaveragedata(hourlytomorrowforecastlist,"empty",collector)

    }
}