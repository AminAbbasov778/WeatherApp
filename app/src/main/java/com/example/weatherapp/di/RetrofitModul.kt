package com.example.weatherapp.di

import android.content.Context
import com.example.weatherapp.sendRequest.RequestService

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModul {



    @Provides
    @Singleton
    fun createretrofit(): Retrofit {
        val baseurl = "https://api.openweathermap.org/data/2.5/"
        var retrofit =
            Retrofit.Builder().baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit
    }

    @Provides
    @Singleton
    fun connectionwithrequest(): RequestService {
        return createretrofit().create(RequestService::class.java)
    }










}