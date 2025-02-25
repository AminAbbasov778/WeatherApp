package com.example.weatherapp.UseCases

import com.example.weatherapp.responseModel.HourlyForecastResponse
import com.example.weatherapp.responseModel.Item0
import javax.inject.Inject

class FiveDaysHourlyForecastToMapUseCase @Inject constructor() {
    fun addfivedayshourlyforecasttomap(hourlyforecast: HourlyForecastResponse,collector: UseCaseCollector): MutableMap<String, ArrayList<Item0>> {
        var dayOfMonthUseCase = collector.dayOfMonthUseCase
        var hourlyforecastlist = hourlyforecast.list
        var hourlyforecastmap = mutableMapOf<String, ArrayList<Item0>>()
        for (forecast in hourlyforecastlist) {
            var key =dayOfMonthUseCase.getdayofmonth(forecast.dtTxt).toString()


            if (hourlyforecastmap[key].isNullOrEmpty()) {
                hourlyforecastmap[key] = arrayListOf()
            }
            hourlyforecastmap[key]!!.add(forecast)

        }
        return hourlyforecastmap

    }

}