package com.bbbrrr8877.coremvvmtest.weatherList.data

import com.barbusya.android.weatherapp.data.Current
import com.barbusya.android.weatherapp.data.Forecast
import com.barbusya.android.weatherapp.data.ForecastDays
import com.barbusya.android.weatherapp.data.Location
import com.bbbrrr8877.coremvvmtest.weatherList.domain.WeatherListDomain
import com.google.gson.annotations.SerializedName

interface WeatherCloud {

    fun <T> map(mapper: Mapper<T>): T

    class Empty : WeatherCloud {
        override fun <T> map(mapper: Mapper<T>): T =
            mapper.map("none", "none", emptyList())
    }

    data class Base(
       val weatherRequest: WeatherRequest
    ) : WeatherCloud {

        override fun <T> map(mapper: Mapper<T>): T =
            mapper.map(weatherRequest.location.city, weatherRequest.current.lastUpdate, weatherRequest.forecast.forecastDays)
    }

    interface Mapper<T> {

        fun map(name: String, date: String, weatherList: List<ForecastDays>): T

        class Base : Mapper<WeatherListDomain> {
            override fun map(
                name: String,
                date: String,
                weatherList: List<ForecastDays>
            ): WeatherListDomain {
                val result =
                    weatherList.map { "${it.date}    temperature: ${it.day.avgTempC.toInt()}°C" }
                return WeatherListDomain.Base(name, date, result)
            }
        }
    }
}