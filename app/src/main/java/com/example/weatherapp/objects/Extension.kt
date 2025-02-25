package com.example.weatherapp.objects

import android.view.View
import android.widget.ImageView
import com.squareup.picasso.Picasso

object Extension {

    fun ImageView.loadurl(url : String){
        Picasso.get().load(url).into(this)
    }

    fun View.gone(){
        this.visibility = View.INVISIBLE
    }
    fun View.visible(){
        this.visibility = View.VISIBLE
    }
}