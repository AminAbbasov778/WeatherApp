package com.example.weatherapp.UseCases

import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.repository.WeatherAppApiRepository
import com.example.weatherapp.responseModel.ForecastResponseForDay
import com.example.weatherapp.responseModel.HourlyForecastResponse
import javax.inject.Inject

class TomorrowButtonIsTrueUseCase @Inject constructor() {
    fun tomorrowbuttonistrue(hourlyForecast: MutableLiveData<HourlyForecastResponse>,
                             forecastresponseforday: MutableLiveData<ForecastResponseForDay>,
                             collector: UseCaseCollector, weatherapprepository: WeatherAppApiRepository
    ){
        hourlyForecast.value?.let {
            forecastresponseforday.value?.let {

                collector.liveDataOfForecastResponseForDayUseCsse.updatetommorrowlivedataofforecastresponseforday(hourlyForecast,forecastresponseforday,collector)

                collector.liveDataOfTomorrowHourlyForecastUseCase.updatelivedataoftomorrowhourlyforecast(hourlyForecast,collector)


            }

        }
    }

}