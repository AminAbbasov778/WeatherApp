package com.example.weatherapp.repository

import android.content.Context
import com.example.weatherapp.sendRequest.RequestService
import javax.inject.Inject

class WeatherAppApiRepository @Inject constructor(private val api : RequestService) {
  private val key = "b81dfa3c9c8b49fbf9c19f34d905927e"
  suspend  fun getdatafromapi(cityname : String) =  api.getresponse(cityname, key, "metric")
  suspend fun gethourlyforecastdata(cityname: String,cnt : String) = api.gethourlyforecastresponse(cityname,key,"metric",cnt)





}