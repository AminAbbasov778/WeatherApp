package com.example.weatherapp.UseCases

import javax.inject.Inject
import kotlin.math.roundToInt

class RoundUseCase  @Inject constructor(){
    fun roundedtemp(temp : Double) : Int{
        var rounded = temp.roundToInt()
        return rounded
    }



}