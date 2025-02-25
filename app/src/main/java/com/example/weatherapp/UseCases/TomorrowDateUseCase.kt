package com.example.weatherapp.UseCases

import android.icu.util.Calendar
import javax.inject.Inject

class TomorrowDateUseCase @Inject constructor() {
    fun gettomorrowdate(collector: UseCaseCollector): String{
        var monthWithNumberToMonthWithWords = collector.monthWithNumberToMonthWithWords
        var calendar = Calendar.getInstance()

        calendar.add(Calendar.DATE,1)
        var tomorrowmonthwithnumber = calendar.get(Calendar.MONTH)
        var fulldate: String? = null
        var month =monthWithNumberToMonthWithWords.convertmonthwithnumbertomonthwithwords(tomorrowmonthwithnumber)
        var day = calendar.get(Calendar.DAY_OF_MONTH)

        fulldate = "$month $day"

        return fulldate
    }
}

