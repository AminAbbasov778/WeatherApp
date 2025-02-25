package com.example.weatherapp.UseCases

import java.util.Locale
import javax.inject.Inject

class UnixTimeToCurrentFormatUseCase @Inject constructor() {

    fun changeunixtimetotocurrentformat(unixtime: Int): String {
        var date = java.sql.Date(unixtime.toLong() * 1000)
        var format = android.icu.text.SimpleDateFormat("HH:mm", Locale.getDefault())
        return format.format(date)
    }

}