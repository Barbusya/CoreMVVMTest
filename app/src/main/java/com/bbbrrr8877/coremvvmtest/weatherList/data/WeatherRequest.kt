package com.bbbrrr8877.coremvvmtest.weatherList.data

import com.barbusya.android.weatherapp.data.Current
import com.barbusya.android.weatherapp.data.Forecast
import com.barbusya.android.weatherapp.data.Location
import com.google.gson.annotations.SerializedName

data class WeatherRequest(
    @SerializedName("location")
    val location: Location,
    @SerializedName("current")
    val current: Current,
    @SerializedName("forecast")
    val forecast: Forecast,
)
