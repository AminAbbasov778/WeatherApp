package com.example.weatherapp.UseCases

import com.example.weatherapp.responseModel.Item0
import javax.inject.Inject

class WayThatFindTheMostUsedIconUseCase @Inject constructor() {
    fun waythatfindthemostusedicon(hourlyforecast: ArrayList<Item0>): String {
        var icons = HashMap<String, Int>()
        for (forecast in hourlyforecast) {
            var icon = forecast.weather[0].icon
            icons[icon!!] = icons.getOrDefault(icon, 0) + 1
        }
        var themostusedicon = icons.maxByOrNull { it.value }?.key ?: "Empty"

        return themostusedicon
    }

}