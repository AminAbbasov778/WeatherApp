package com.example.weatherapp.UseCases

import javax.inject.Inject

class MonthWithNumberToMonthWithWordsUseCase @Inject constructor() {
    fun convertmonthwithnumbertomonthwithwords(monthwithnumber: Int): String {
        var month: String? = null
        var monthsarray = arrayOf(
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        )
        for (a in 0 until monthsarray.size) {
            if (a == monthwithnumber) {
                month = monthsarray[a]
            }


        }
        return month!!
    }
}