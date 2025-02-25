package com.example.weatherapp.UseCases

import com.example.weatherapp.objects.Extension.loadurl
import com.example.weatherapp.responseModel.HourlyForecastResponse
import com.example.weatherapp.responseModel.Item0
import javax.inject.Inject

class TomorrowHourlyForecastListUseCase @Inject constructor() {
    fun gettomorrowhourlyforecastlist(hourlyforecast: HourlyForecastResponse,collector: UseCaseCollector): ArrayList<Item0> {
        var tomorrowDayOfMonthUseCase = collector.tomorrowDayOfMonthUseCase
        var dayOfMonthUseCase = collector.dayOfMonthUseCase
        var tomorrowday = tomorrowDayOfMonthUseCase.gettomorrowdayofmonth()
        var hourlytomorrowforecast = ArrayList<Item0>()
        for (forecast in hourlyforecast.list) {
            var dayofforecast =dayOfMonthUseCase.getdayofmonth(forecast.dtTxt)

            if (dayofforecast == tomorrowday) {
                var time =   collector.timeUseCAse.gettime(forecast.dtTxt)
                var iconurl = collector.iconUrlUseCase.geticonurl(forecast.weather[0].icon!!)
                var roundedtemp =  collector.formatTempForAdapterUseCase.formattempforadapter(forecast.main.temp,collector)
             val updatedforecast = forecast.copy(time = time, main =
                     forecast.main.copy(roundedtemp = roundedtemp),
                 weather = forecast.weather.map { it.copy(iconurl = iconurl)})

                hourlytomorrowforecast.add(updatedforecast)
            }
        }
        return hourlytomorrowforecast


    }






















}