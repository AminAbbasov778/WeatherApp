package com.example.weatherapp.UseCases

import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.responseModel.HourlyForecastResponse
import javax.inject.Inject

class TomorrowAndFiveDaysButtonsAreFalseUseCase @Inject constructor() {

    fun tomorrowandfivedaysbuttonsarefalse(hourlyForecast: MutableLiveData<HourlyForecastResponse>,collector: UseCaseCollector) {
        hourlyForecast.value = hourlyForecast.value!!.copy(
            list = collector.formatedHourlyForecastListUseCase.gethourlyforecastlist(hourlyForecast.value!!,collector)
        )
    }

}