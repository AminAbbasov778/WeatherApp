package com.example.weatherapp.viewModel

import androidx.lifecycle.ViewModel
import com.example.weatherapp.repository.WeatherAppApiRepository
import com.example.weatherapp.repository.WeatherAppSharedPrefRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(var weatherAppSharedPrefRepository: WeatherAppSharedPrefRepository) : ViewModel() {

    fun removebooleanvalue(key: String) {
        weatherAppSharedPrefRepository.removebooleanvalue(key)

    }
}