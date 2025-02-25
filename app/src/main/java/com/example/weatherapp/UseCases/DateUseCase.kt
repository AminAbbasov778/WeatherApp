package com.example.weatherapp.UseCases

import android.icu.util.Calendar
import javax.inject.Inject

class DateUseCase @Inject constructor() {

    fun getdate(collector: UseCaseCollector): String {
        var monthWithNumberToMonthWithWords = collector.monthWithNumberToMonthWithWords
        var calendar = Calendar.getInstance()
        var fulldate: String? = null
        var monthwithnumber = calendar.get(Calendar.MONTH)
        var month =monthWithNumberToMonthWithWords.convertmonthwithnumbertomonthwithwords(monthwithnumber)
        var day = calendar.get(Calendar.DAY_OF_MONTH)
        var hour = calendar.get(Calendar.HOUR_OF_DAY)
        var minute = calendar.get(Calendar.MINUTE)
        if (minute < 10) {
            fulldate = "$month $day, $hour:0$minute"
        } else {
            fulldate = "$month $day, $hour:$minute"
        }
        return fulldate
    }



}