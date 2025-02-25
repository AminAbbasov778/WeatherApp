package com.example.weatherapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.weatherapp.databinding.ThreeHourlyForecastRecItemsBinding
import com.example.weatherapp.objects.Extension.loadurl
import com.example.weatherapp.responseModel.HourlyForecastResponse
import com.example.weatherapp.responseModel.Item0


class HourlyForecastAdapter:
    RecyclerView.Adapter<HourlyForecastAdapter.HourlyForecastViewHolder>() {


    var hourlyforecastlist = arrayListOf<Item0>()

    inner class HourlyForecastViewHolder(val binding: ThreeHourlyForecastRecItemsBinding) :
        ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyForecastViewHolder {
        var binding = ThreeHourlyForecastRecItemsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HourlyForecastViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return hourlyforecastlist.size
    }

    override fun onBindViewHolder(holder: HourlyForecastViewHolder, position: Int) {


        holder.binding.hourlyforecast = hourlyforecastlist[position]


    }

    fun updatehourlyforecast(element: ArrayList<HourlyForecastResponse>) {
        hourlyforecastlist.clear()
        hourlyforecastlist.addAll(element[0].list)
        notifyDataSetChanged()
    }
}