package com.bbbrrr8877.coremvvmtest.weatherList.presentation

import com.github.johnnysc.coremvvm.presentation.NavigationScreen
import com.github.johnnysc.coremvvm.presentation.ShowStrategy

class WeatherListNavigationScreen(showStrategy: ShowStrategy = ShowStrategy.REPLACE) :
    NavigationScreen(
        "WeatherListNavigationScreen",
        WeatherListFragment::class.java,
        showStrategy
    )