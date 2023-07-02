package com.bbbrrr8877.coremvvmtest.weatherList.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("api.weatherapi.com/v1/current.json? &q=London&aqi=no")
    suspend fun weatherList(
        @Query("key") accessKey: String = "971bcc646b804390ba3105555220401"
    ) : WeatherCloud.Base

    @GET("v1/forecast.json?")
    fun fetchWeather(@Query("q") query: String): WeatherCloud.Base

    @GET("v1/forecast.json?")
    fun searchWeather(@Query("q") query: String): WeatherCloud.Base
}