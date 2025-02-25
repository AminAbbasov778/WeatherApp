package com.example.weatherapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.weatherapp.databinding.FiveDaysForecastRecBinding
import com.example.weatherapp.objects.Extension.loadurl
import com.example.weatherapp.responseModel.AverageForecast
import com.example.weatherapp.responseModel.Item0

class FiveDaysForecastAdapter : RecyclerView.Adapter<FiveDaysForecastAdapter.FiveDaysDForecastViewholder>() {
    var list = ArrayList<AverageForecast>()

    inner class FiveDaysDForecastViewholder(val binding : FiveDaysForecastRecBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FiveDaysDForecastViewholder {
        var binding = FiveDaysForecastRecBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FiveDaysDForecastViewholder(binding)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: FiveDaysDForecastViewholder, position: Int) {

        holder.binding.fivedaysforecast =  list[position]



    }


    fun updatelist(newlist : ArrayList<AverageForecast>){
        list.clear()
        list.addAll(newlist)
        notifyDataSetChanged()

    }
}