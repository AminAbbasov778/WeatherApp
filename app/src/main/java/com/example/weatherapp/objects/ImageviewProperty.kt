package com.example.weatherapp.objects

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.weatherapp.objects.Extension.loadurl

object ImageviewProperty {
    @BindingAdapter("loadurl")
    @JvmStatic
    fun loadurlproperty(imageView: ImageView,url : String){
        imageView.loadurl(url)

    }
}