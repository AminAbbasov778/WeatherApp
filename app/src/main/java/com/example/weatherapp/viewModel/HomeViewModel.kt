package com.example.weatherapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.responseModel.AverageForecast
import com.example.weatherapp.responseModel.ForecastResponseForDay
import com.example.weatherapp.responseModel.HourlyForecastResponse
import com.example.weatherapp.UseCases.UseCaseCollector
import com.example.weatherapp.datamodel.DataModel
import com.example.weatherapp.objects.mysharedpreferencekeys
import com.example.weatherapp.repository.WeatherAppApiRepository
import com.example.weatherapp.repository.WeatherAppSharedPrefRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() :
    ViewModel() {
    @Inject
    lateinit var collector: UseCaseCollector

    @Inject
    lateinit var weatherAppSharedPrefRepository: WeatherAppSharedPrefRepository


    var mutablehourlyForecast = MutableLiveData<HourlyForecastResponse>()
    var immutablehourlyForecast: LiveData<HourlyForecastResponse> = mutablehourlyForecast
    var mutableforecastresponseforday = MutableLiveData<ForecastResponseForDay>()
    var immutableforecastresponseforday: LiveData<ForecastResponseForDay> =
        mutableforecastresponseforday

    var mutablefivedaysforecast = MutableLiveData<ArrayList<AverageForecast>>()
    var immutablefivedaysforecast: LiveData<ArrayList<AverageForecast>> = mutablefivedaysforecast
    var mutablecityname = MutableLiveData<String>("London")
    var immutablecityname: LiveData<String> = mutablecityname
    var mutabletoday = MutableLiveData<Boolean>(true)
    var immutabletoday: MutableLiveData<Boolean> = mutabletoday
    var mutabletomorrow = MutableLiveData<Boolean>(false)
    var immutabletomorrow: LiveData<Boolean> = mutabletomorrow
    var mutablefivedays = MutableLiveData<Boolean>(false)
    var immutablefivedays: LiveData<Boolean> = mutablefivedays
    var mutabledate = MutableLiveData<String>()
    var immutabledate: LiveData<String> = mutabledate
    var mutabletomorrowdate = MutableLiveData<String>()
    var immutabletomorrowdate: LiveData<String> = mutabletomorrowdate
    var combinedtomorrowlivedata = combine(immutabletomorrow.asFlow(),immutabletomorrowdate.asFlow()){
        tomorrowbutton,tomorrowdate -> listOf(tomorrowbutton,tomorrowdate)
    }.asLiveData()
    var combinedlivedata = combine(immutabletoday.asFlow(),immutabletomorrow.asFlow(),immutablefivedays.asFlow(),immutablecityname.asFlow()){
        today,tomorrow,fivedays,cityname -> listOf(today,tomorrow,fivedays,cityname)
    }.asLiveData()


    fun getweatherdata(cityname: String) {
        viewModelScope.launch {
            try {

                collector.weatherDataFromApiUseCase.getweatherdatafromapi(
                    cityname,
                    mutableforecastresponseforday,
                    collector
                )


            } catch (e: Exception) {
                error(e)
            }

        }
    }

    fun gethourlyforecastdata(cityname: String, cnt: String) {
        viewModelScope.launch {
            try {

                collector.hourlyForecastDataFromApiUseCase.gethourlyforecastdatadromapi(
                    cityname,
                    cnt,
                    mutablehourlyForecast,
                    mutableforecastresponseforday,
                    mutablefivedaysforecast,
                    collector
                )

            } catch (e: Exception) {
                error(e)
            }
        }
    }

    fun savecityname(key: String, value: String) {
        weatherAppSharedPrefRepository.savecityname(key, value)
        mutablecityname.value = value

    }

    fun getcityname(key: String, defaultvalue: String) {
        mutablecityname.value = weatherAppSharedPrefRepository.getcityname(key, defaultvalue)


    }


    fun savebooleanvalue(key: String, value: Boolean) {
        weatherAppSharedPrefRepository.savebooleanvalue(key, value)
        if (key == mysharedpreferencekeys.todaybutton) {
            mutabletoday.value = value
        } else if (key == mysharedpreferencekeys.tomorrowbutton) {
            mutabletomorrow.value = value

        } else {
            mutablefivedays.value = value


        }
    }


    fun getbooleanvalue(key: String) {
        var value = weatherAppSharedPrefRepository.getbooleanvalue(key, false)
        if (key == mysharedpreferencekeys.todaybutton) {
            if(immutabletoday.value != true){
                mutabletoday.value = value
            }


        } else if (key == mysharedpreferencekeys.tomorrowbutton) {
            mutabletomorrow.value = value

        } else if(key == mysharedpreferencekeys.fivedaysbutton) {
            mutablefivedays.value = value


        }
    }


    fun getdate() {
        mutabledate.value = collector.dateUseCase.getdate(collector)
    }

    fun gettomorrowdate() {
        mutabletomorrowdate.value = collector.tomorrowDateUseCase.gettomorrowdate(collector)
    }



}



