package com.bbbrrr8877.coremvvmtest.weatherList.domain

import com.bbbrrr8877.coremvvmtest.weatherList.presentation.WeatherListDateUi
import com.bbbrrr8877.coremvvmtest.weatherList.presentation.WeatherListUi
import com.bbbrrr8877.coremvvmtest.weatherList.presentation.WeatherUi
import com.github.johnnysc.coremvvm.presentation.adapter.ItemUi


interface WeatherListDomain {

    fun <T> map(mapper: Mapper<T>): T

    class Base(
        private val name: String,
        private val date: String,
        private val list: List<String>,
        private val iconUrl: String
    ) : WeatherListDomain {
        override fun <T> map(mapper: Mapper<T>): T = mapper.map(name, date, list, iconUrl)
    }

    interface Mapper<T> {

        fun map(
            name: String,
            date: String,
            list: List<String>,
            iconUrl: String
        ): T

        class Base() : Mapper<WeatherListUi> {
            override fun map(name: String, date: String, list: List<String>, iconUrl: String): WeatherListUi {
                val finalList = mutableListOf<ItemUi>(WeatherListDateUi("$name -> Last update: $date"))
                finalList.addAll(list.map {
                    WeatherUi(
                        it, it, "https:$iconUrl"
                    )
                })
                return WeatherListUi.Base(finalList)
            }
        }
    }
}