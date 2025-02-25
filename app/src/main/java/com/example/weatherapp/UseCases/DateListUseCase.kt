package com.example.weatherapp.UseCases

import android.util.Log
import com.example.weatherapp.responseModel.HourlyForecastResponse
import javax.inject.Inject

class DateListUseCase @Inject constructor() {
    fun getdatelist(hourlyforecast: HourlyForecastResponse,collector: UseCaseCollector): List<String>{
        var dayOfMonthUseCase = collector.dayOfMonthUseCase
        var monthWithNumberToMonthWithWords = collector.monthWithNumberToMonthWithWords
        var fulldateslist = ArrayList<String>()
        for(forecast in hourlyforecast.list){
            var monthwithnumber =forecast.dtTxt.substring(5,7).toInt()
            var daywithnumber  =dayOfMonthUseCase.getdayofmonth(forecast.dtTxt)
            var monthwittword =monthWithNumberToMonthWithWords.convertmonthwithnumbertomonthwithwords(monthwithnumber-1)
            var fulldate = monthwittword + " " + daywithnumber
            fulldateslist.add(fulldate)
        }
        var distinctedfulldateslist = fulldateslist.distinct()
        Log.e("yoxla91", distinctedfulldateslist.toString(), )
        return distinctedfulldateslist

    }
}