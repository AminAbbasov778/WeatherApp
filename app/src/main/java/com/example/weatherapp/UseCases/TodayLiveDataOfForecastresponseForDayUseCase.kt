package com.example.weatherapp.UseCases

import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.responseModel.ForecastResponseForDay
import retrofit2.Response
import javax.inject.Inject

class TodayLiveDataOfForecastresponseForDayUseCase @Inject constructor() {
    fun updatelivedataofforecastresponseforday(data : Response<ForecastResponseForDay>,forecastresponseforday : MutableLiveData<ForecastResponseForDay>,collector: UseCaseCollector){
        var changedsunsettime =
            collector.unixTimeToCurrentFormatUseCase.changeunixtimetotocurrentformat(data.body()!!.sys.sunset)
        var changedsunrisetime =
            collector.unixTimeToCurrentFormatUseCase.changeunixtimetotocurrentformat(data.body()!!.sys.sunrise)
        var temp = data.body()!!.main.temp
        var mintemp = data.body()!!.main.tempMin
        var maxtemp = data.body()!!.main.tempMax
        var feelsliketemp = data.body()!!.main.feelsLike
        var icon = data.body()!!.weather[0].icon
        forecastresponseforday.value = data.body()
        forecastresponseforday.value = forecastresponseforday.value!!.copy(
            sys = forecastresponseforday.value!!.sys.copy(
                sunrisestring = changedsunrisetime,
                sunsetstring = changedsunsettime
            )
        )
        forecastresponseforday.value = forecastresponseforday.value!!.copy(
            main = forecastresponseforday.value!!.main.copy(
                tempMaxInt =collector.roundUseCase.roundedtemp(maxtemp),
                tempInt = collector.roundUseCase.roundedtemp(temp),
                tempMinInt = collector.roundUseCase.roundedtemp(mintemp),
                feelsLikeInt =collector.roundUseCase.roundedtemp(feelsliketemp)
            )
        )

        forecastresponseforday.value =
            forecastresponseforday.value!!.copy(weather = forecastresponseforday.value!!.weather.map { it ->
                it.copy(iconurl = collector.iconUrlUseCase.geticonurl(icon!!))
            })
    }
}