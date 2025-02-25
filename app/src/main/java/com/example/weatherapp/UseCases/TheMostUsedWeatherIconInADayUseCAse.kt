package com.example.weatherapp.UseCases

import com.example.weatherapp.responseModel.HourlyForecastResponse
import javax.inject.Inject

class TheMostUsedWeatherIconInADayUseCAse @Inject constructor() {
    fun themostusedweathericoninaday(hourlyforecast: HourlyForecastResponse,collector: UseCaseCollector): String {
        var tomorrowHourlyForecastListUseCase = collector.tomorrowHourlyForecastListUseCase
        var wayThatFindTheMostUsedIconUseCase = collector.wayThatFindTheMostUsedIconUseCase
        var hourlyforecast =tomorrowHourlyForecastListUseCase.gettomorrowhourlyforecastlist(hourlyforecast,collector)
        return wayThatFindTheMostUsedIconUseCase.waythatfindthemostusedicon(hourlyforecast)


    }

}