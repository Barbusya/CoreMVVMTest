package com.bbbrrr8877.coremvvmtest.weatherList.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("v1/forecast.json?key=971bcc646b804390ba3105555220401&q=London&days=5&aqi=no&alerts=no")
    suspend fun weatherList() : WeatherRequest
}