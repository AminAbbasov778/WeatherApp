package com.example.weatherapp.UseCases

import android.icu.util.Calendar
import javax.inject.Inject

class TomorrowDayOfMonthUseCase @Inject constructor() {
    fun gettomorrowdayofmonth(): Int {
        var calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, 1)
        var tomorrowday = calendar.get(Calendar.DAY_OF_MONTH)

        return tomorrowday
    }
}