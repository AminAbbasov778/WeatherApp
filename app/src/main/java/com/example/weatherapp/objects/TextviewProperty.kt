package com.example.weatherapp.objects

import android.widget.TextView
import androidx.databinding.BindingAdapter


object TextviewProperty {

    @BindingAdapter("formatdoubledata")
    @JvmStatic
    fun formatdoubledata(textview: TextView,speed : Double){
        textview.text = String.format("%.1f km/h",speed)

    }
    @BindingAdapter("formatintdata")
    @JvmStatic
    fun formatintdata(textview: TextView,pressure: Int){
         textview.text = String.format("%d hPa",pressure)
    }
}
