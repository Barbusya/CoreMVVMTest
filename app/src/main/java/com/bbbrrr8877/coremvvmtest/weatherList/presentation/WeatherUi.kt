package com.bbbrrr8877.coremvvmtest.weatherList.presentation

import com.github.johnnysc.coremvvm.presentation.adapter.ItemUi
import com.github.johnnysc.coremvvm.presentation.adapter.MyView

class WeatherUi(
    private val id: String,
    private val text: String,
) : ItemUi {

    override fun content(): String = text

    override fun id(): String = id

    override fun show(vararg views: MyView) {
        views[0].show(text)
    }

    override fun type(): Int = 1
}