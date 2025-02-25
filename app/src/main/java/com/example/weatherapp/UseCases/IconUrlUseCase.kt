package com.example.weatherapp.UseCases

import javax.inject.Inject

class IconUrlUseCase @Inject constructor() {

    fun geticonurl(icon : String)="https://openweathermap.org/img/wn/${icon}@2x.png"

}