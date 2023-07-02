package com.bbbrrr8877.coremvvmtest.weatherList.data

import com.barbusya.android.weatherapp.data.Current
import com.barbusya.android.weatherapp.data.Forecast
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
        @SerializedName("location")
        val location: Location,
        @SerializedName("current")
        val current: Current,
        @SerializedName("forecast")
        var forecast: Forecast,
    ) : WeatherCloud {
        val name = location.city
        val date = current.
        override fun <T> map(mapper: Mapper<T>): T =
            mapper.map(name, date, tempC)
    }

    interface Mapper<T> {

        fun map(base: String, date: String, weatherList: List<String>): T

        class Base : Mapper<WeatherListDomain> {
            override fun map(
                base: String,
                date: String,
                weatherList: List<String>
            ): WeatherListDomain {
                val result =
                    weatherList.map { it }
                return WeatherListDomain.Base(base, date, result)
            }
        }
    }
}