package com.example.weatherapp.UseCases

import javax.inject.Inject

class DayOfMonthUseCase @Inject constructor() {
    fun getdayofmonth(date: String): Int {
        var day = date.substring(8, 10).toInt()

        return day
    }
}