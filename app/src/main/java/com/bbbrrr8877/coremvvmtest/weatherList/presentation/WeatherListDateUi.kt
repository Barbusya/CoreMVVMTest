package com.bbbrrr8877.coremvvmtest.weatherList.presentation

import com.github.johnnysc.coremvvm.presentation.adapter.ItemUi
import com.github.johnnysc.coremvvm.presentation.adapter.MyView

class WeatherListDateUi(private val text: String): ItemUi {

    override fun content(): String = text

    override fun id(): String = text

    override fun show(vararg views: MyView) = views[0].show(text)

    override fun type(): Int = 2
}