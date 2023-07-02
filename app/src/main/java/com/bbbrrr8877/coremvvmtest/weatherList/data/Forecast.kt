package com.barbusya.android.weatherapp.data

import com.google.gson.annotations.SerializedName

data class Forecast (
    @SerializedName("forecastday")
    val forecastDays: List<ForecastDays> = emptyList()
)

data class ForecastDays(
    @SerializedName("date")
    val date: String = "",
    @SerializedName("day")
    val day: Day,
    @SerializedName("hour")
    val hours: List<Hours> = emptyList(),
)

data class Day (
    @SerializedName("maxtemp_c")
    val maxTempC: Float = 0f,
    @SerializedName("mintemp_c")
    val minTempC: Float = 0f,
)

data class Hours(
    @SerializedName("time_epoch")
    val hoursTime: Float = 0f,
    @SerializedName("temp_c")
    val hoursTempC: Float = 0f,
)
