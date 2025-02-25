package com.example.weatherapp.repository

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class WeatherAppSharedPrefRepository @Inject constructor(var sharedPreferences: SharedPreferences) {

    fun removebooleanvalue(key : String){
        sharedPreferences.edit().remove(key).commit()
    }
    fun savecityname(key: String,value: String  ){
        sharedPreferences.edit().putString(key,value).apply()
    }
    fun getcityname(key: String,defaultvalue:String) = sharedPreferences.getString(key,defaultvalue)

    fun savebooleanvalue(key: String,value: Boolean){
        sharedPreferences.edit().putBoolean(key,value).apply()
    }
    fun getbooleanvalue(key: String,defaultvalue : Boolean) = sharedPreferences.getBoolean(key,defaultvalue)


}