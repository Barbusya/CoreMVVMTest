package com.bbbrrr8877.coremvvmtest.weatherList.presentation

import com.github.johnnysc.coremvvm.presentation.adapter.GenericAdapter
import com.github.johnnysc.coremvvm.presentation.adapter.ViewHolderFactoryChain

interface WeatherListAdapter {

    class WeatherList : GenericAdapter.Base(
        WeatherListViewHolderFactoryChain(
            WeatherDateViewHolderChain(
                ViewHolderFactoryChain.Exception()
            )
        )
    )
}