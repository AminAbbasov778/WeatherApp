package com.example.weatherapp.UseCases

import javax.inject.Inject

class TimeUseCAse @Inject constructor() {
    fun gettime(fulldate : String) = fulldate.substring(11,16)
}