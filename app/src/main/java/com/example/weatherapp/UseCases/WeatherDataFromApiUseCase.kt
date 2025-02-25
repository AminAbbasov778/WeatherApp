package com.example.weatherapp.UseCases

import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.repository.WeatherAppApiRepository
import com.example.weatherapp.responseModel.ForecastResponseForDay
import javax.inject.Inject

class WeatherDataFromApiUseCase @Inject constructor(var weatherapprepository: WeatherAppApiRepository) {
   suspend fun getweatherdatafromapi(cityname : String,forecastresponseforday : MutableLiveData<ForecastResponseForDay>, collector: UseCaseCollector){
        var data = weatherapprepository.getdatafromapi(cityname)
        if (data.isSuccessful) {
           collector.todayLiveDataOfForecastresponseForDayUseCase.updatelivedataofforecastresponseforday(data,forecastresponseforday,collector)
        }
    }
}
