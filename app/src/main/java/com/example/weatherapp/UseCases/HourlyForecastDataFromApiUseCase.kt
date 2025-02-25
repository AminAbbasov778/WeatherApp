package com.example.weatherapp.UseCases

import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.objects.mysharedpreferencekeys
import com.example.weatherapp.repository.WeatherAppApiRepository
import com.example.weatherapp.repository.WeatherAppSharedPrefRepository
import com.example.weatherapp.responseModel.AverageForecast
import com.example.weatherapp.responseModel.ForecastResponseForDay
import com.example.weatherapp.responseModel.HourlyForecastResponse
import javax.inject.Inject

class HourlyForecastDataFromApiUseCase @Inject constructor(var weatherapprepository: WeatherAppApiRepository,var weatherAppSharedPrefRepository: WeatherAppSharedPrefRepository) {
    suspend fun gethourlyforecastdatadromapi(
        cityname: String,
        cnt: String,
        hourlyForecast: MutableLiveData<HourlyForecastResponse>,
        forecastresponseforday:MutableLiveData<ForecastResponseForDay>,
        fivedaysaverageforecast: MutableLiveData<ArrayList<AverageForecast>>,
        collector: UseCaseCollector
    ) {
        var result = weatherapprepository.gethourlyforecastdata(cityname, cnt)
        if (result.isSuccessful && result.body() != null) {
            hourlyForecast.value = result.body()
            var tomorrowbutton = weatherAppSharedPrefRepository.getbooleanvalue(mysharedpreferencekeys.tomorrowbutton, false)
            var fivedaysbutton = weatherAppSharedPrefRepository.getbooleanvalue(mysharedpreferencekeys.fivedaysbutton, false)
            if (!tomorrowbutton && !fivedaysbutton) {
               collector.tomorrowAndFiveDaysButtonsAreFalseUseCase.tomorrowandfivedaysbuttonsarefalse(hourlyForecast,collector)
            } else if (tomorrowbutton) {
                hourlyForecast.value?.let {
                    collector.tomorrowButtonIsTrueUseCase.tomorrowbuttonistrue(hourlyForecast,forecastresponseforday,collector,weatherapprepository)
                }
            } else if (fivedaysbutton) {
                hourlyForecast.value?.let {
                    fivedaysaverageforecast.value =
                        collector.theLastStepForFiveDaysForecastUseCase.getfinalfivedaysforecast(
                            hourlyForecast.value!!,collector
                        )


                }
            }


        }
    }
}