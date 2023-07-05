package com.bbbrrr8877.coremvvmtest.weatherList.presentation

import com.github.johnnysc.coremvvm.core.Mapper
import com.github.johnnysc.coremvvm.presentation.adapter.ItemUi

interface WeatherListUi : Mapper.Unit<Mapper.Unit<List<ItemUi>>> {

    class Base(private val list: List<ItemUi>) : WeatherListUi {
        override fun map(data: Mapper.Unit<List<ItemUi>>) = data.map(list)
    }
}