package com.bbbrrr8877.coremvvmtest.weatherList.domain

import com.bbbrrr8877.coremvvmtest.weatherList.presentation.WeatherListDateUi
import com.bbbrrr8877.coremvvmtest.weatherList.presentation.WeatherListUi
import com.bbbrrr8877.coremvvmtest.weatherList.presentation.WeatherUi
import com.github.johnnysc.coremvvm.presentation.adapter.ItemUi


interface WeatherListDomain {

    fun <T> map(mapper: Mapper<T>): T

    class Base(
        private val base: String,
        private val date: String,
        private val list: List<String>
    ) : WeatherListDomain {
        override fun <T> map(mapper: Mapper<T>): T = mapper.map(base, date, list)
    }

    interface Mapper<T> {

        fun map(
            base: String,
            date: String,
            list: List<String>
        ): T

        class Base() : Mapper<WeatherListUi> {
            override fun map(base: String, date: String, list: List<String>): WeatherListUi {
                val finalList = mutableListOf<ItemUi>(WeatherListDateUi("Last update: $date"))
                finalList.addAll(list.map {
                    WeatherUi(
                        it, "$base/${it}"
                    )
                })
                return WeatherListUi.Base(finalList)
            }
        }
    }
}