package com.bbbrrr8877.coremvvmtest.weatherList.presentation

import com.github.johnnysc.coremvvm.presentation.Communication

interface WeatherListCommunication : Communication.Mutable<WeatherListUi> {
    class Base : Communication.UiUpdate<WeatherListUi>(), WeatherListCommunication
}