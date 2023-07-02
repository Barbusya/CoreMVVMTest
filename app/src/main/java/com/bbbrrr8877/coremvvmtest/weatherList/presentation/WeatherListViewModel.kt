package com.bbbrrr8877.coremvvmtest.weatherList.presentation

import com.bbbrrr8877.coremvvmtest.weatherList.domain.WeatherListInteractor
import com.github.johnnysc.coremvvm.core.Dispatchers
import com.github.johnnysc.coremvvm.presentation.BackPress
import com.github.johnnysc.coremvvm.presentation.CanGoBack
import com.github.johnnysc.coremvvm.presentation.ProgressCommunication
import com.github.johnnysc.coremvvm.presentation.Visibility

class WeatherListViewModel(
    canGoBackCallback: CanGoBack.Callback,
    private val interactor: WeatherListInteractor,
    progressCommunication: ProgressCommunication.Update,
    communication: WeatherListCommunication,
    dispatchers: Dispatchers,
) : BackPress.ViewModel<WeatherListUi>(
    canGoBackCallback,
    communication,
    dispatchers
) {

    private val atFinish = {
        progressCommunication.map(Visibility.Gone())
        canGoBack = true
    }

    private var canGoBack = true

    private val canGoBackCallbackInner = object : CanGoBack {
        override fun canGoBack(): Boolean = canGoBack
    }

    init {
        canGoBack = false
        progressCommunication.map(Visibility.Visible())
        handle {
            //Todo interactor
        }
    }

    override fun updateCallbacks() {
        canGoBackCallback.updateCallback(canGoBackCallbackInner)
    }
}