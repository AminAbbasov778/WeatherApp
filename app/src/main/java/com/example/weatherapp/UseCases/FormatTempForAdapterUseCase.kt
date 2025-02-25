package com.example.weatherapp.UseCases

import javax.inject.Inject

class FormatTempForAdapterUseCase @Inject constructor() {
    fun formattempforadapter(temp : Double, collector: UseCaseCollector ): String{
        var roundUseCase = collector.roundUseCase
        return roundUseCase.roundedtemp(temp).toString() + "°"
    }

}