package com.example.weatherapp.UseCases

import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.responseModel.HourlyForecastResponse
import javax.inject.Inject

class LiveDataOfTomorrowHourlyForecastUseCase  @Inject constructor(){
    fun updatelivedataoftomorrowhourlyforecast( hourlyForecast : MutableLiveData<HourlyForecastResponse>,collector: UseCaseCollector){

        hourlyForecast.value =
            hourlyForecast.value!!.copy(
                list = collector.tomorrowHourlyForecastListUseCase.gettomorrowhourlyforecastlist(
                    hourlyForecast.value!!,collector
                )
            )
    }
}