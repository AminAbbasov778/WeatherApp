package com.example.weatherapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.weatherapp.UseCases.UseCaseCollector
import com.example.weatherapp.responseModel.ForecastResponseForDay
import com.example.weatherapp.databinding.WeatherRecItemsBinding
import com.example.weatherapp.responseModel.HourlyForecastResponse
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class WeatherAdapter() : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    var forecastlist = ArrayList<ForecastResponseForDay>()
    var hourlyforecastlist = ArrayList<HourlyForecastResponse>()

    var adapter = HourlyForecastAdapter()

    inner class WeatherViewHolder(val binding: WeatherRecItemsBinding) : ViewHolder(binding.root){

    init {
        binding.hourlyforecastrecview.adapter = adapter
    }
}





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val binding = WeatherRecItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return WeatherViewHolder(binding)
    }

    override fun getItemCount(): Int {
      return forecastlist.size
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
       holder.binding.forecastforday = forecastlist[position]
        

    }
    fun updateforecast( element : ForecastResponseForDay){
        forecastlist.clear()
        forecastlist.add(element)
        notifyDataSetChanged()
    }

    fun  updatehourlyforecast(element : HourlyForecastResponse){
        hourlyforecastlist.clear()
        hourlyforecastlist.add(element)
        adapter.updatehourlyforecast(hourlyforecastlist)

    }
}