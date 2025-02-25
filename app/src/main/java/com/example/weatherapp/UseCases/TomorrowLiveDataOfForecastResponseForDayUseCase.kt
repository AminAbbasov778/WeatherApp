package com.example.weatherapp.UseCases

import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.repository.WeatherAppApiRepository
import com.example.weatherapp.responseModel.ForecastResponseForDay
import com.example.weatherapp.responseModel.HourlyForecastResponse
import javax.inject.Inject

class TomorrowLiveDataOfForecastResponseForDayUseCase @Inject constructor(var weatherapprepository: WeatherAppApiRepository) {
    fun updatetommorrowlivedataofforecastresponseforday(hourlyForecast: MutableLiveData<HourlyForecastResponse>,
                                               forecastresponseforday: MutableLiveData<ForecastResponseForDay>,collector: UseCaseCollector){
        var averageForecast =
            collector.averageTomorrowForecastUseCase.getaveragetomorrowforecast(hourlyForecast.value!!,collector)
        var icon =
            collector.mostUsedWeatherIconInADayUseCAse.themostusedweathericoninaday(
                hourlyForecast.value!!,collector
            )
        forecastresponseforday.value = forecastresponseforday.value!!.copy(
            main =forecastresponseforday.value!!.main.copy(

                tempInt = averageForecast.averagetemps,
                tempMinInt = averageForecast.averagemintemps,
                tempMaxInt = averageForecast.averagemaxtemps,
                feelsLikeInt = averageForecast.averagefeelsliketemps,
                humidity = averageForecast.averagehumiditypercentages,
                pressure = averageForecast.averagepressure,
            ),
            wind = forecastresponseforday.value!!.wind.copy(
                speed = averageForecast.averagewindspeeds,
                deg = 0
            ),
            weather =forecastresponseforday.value!!.weather.map { weather ->
                weather.copy(
                    iconurl = collector.iconUrlUseCase.geticonurl(
                        icon
                    )
                )
            }
        )



    }
}