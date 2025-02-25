package com.example.weatherapp.sendRequest

import com.example.weatherapp.responseModel.ForecastResponseForDay
import com.example.weatherapp.responseModel.HourlyForecastResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface RequestService {
    @GET("weather")
     suspend  fun getresponse(@Query("q") q : String,@Query("appid") appid : String,@Query("units") units : String): Response<ForecastResponseForDay>

       @POST("forecast")
      suspend   fun gethourlyforecastresponse(@Query("q") q : String,@Query("appid") appid : String,@Query("units") units : String,@Query("cnt") cnt : String): Response<HourlyForecastResponse>

}