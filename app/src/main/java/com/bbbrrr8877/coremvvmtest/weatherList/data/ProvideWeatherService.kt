package com.bbbrrr8877.coremvvmtest.weatherList.data

import com.github.johnnysc.coremvvm.data.MakeService
import com.github.johnnysc.coremvvm.data.ProvideRetrofitBuilder

interface ProvideWeatherService {

    fun weatherService(): WeatherService

    class Base(
        retrofitBuilder: ProvideRetrofitBuilder,
    ) : MakeService.Abstract(
        retrofitBuilder
    ), ProvideWeatherService {

        override fun baseUrl(): String = "https://api.weatherapi.com/"

        override fun weatherService(): WeatherService = service(WeatherService::class.java)
    }
}