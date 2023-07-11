package com.bbbrrr8877.coremvvmtest.weatherList.data

import android.util.Log
import com.barbusya.android.weatherapp.data.ForecastDays
import com.bbbrrr8877.coremvvmtest.weatherList.domain.WeatherListDomain

interface WeatherCloud {

    fun <T> map(mapper: Mapper<T>): T

    class Empty : WeatherCloud {
        override fun <T> map(mapper: Mapper<T>): T =
            mapper.map("none", "none", emptyList(), "none")
    }

    data class Base(
       val weatherRequest: WeatherRequest
    ) : WeatherCloud {

        override fun <T> map(mapper: Mapper<T>): T =
            mapper.map(weatherRequest.location.city, weatherRequest.current.lastUpdate, weatherRequest.forecast.forecastDays, weatherRequest.current.currentCondition.iconUrl)
    }

    interface Mapper<T> {

        fun map(name: String, date: String, weatherList: List<ForecastDays>, iconUrl: String): T

        class Base : Mapper<WeatherListDomain> {
            override fun map(
                name: String,
                date: String,
                weatherList: List<ForecastDays>,
                iconUrl: String
            ): WeatherListDomain {
                val result =
                    weatherList.map { "${it.date}    temperature: ${it.day.avgTempC.toInt()}°C" }
                return WeatherListDomain.Base(name, date, result, iconUrl)
            }
        }
    }
}