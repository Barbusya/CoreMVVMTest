package com.bbbrrr8877.coremvvmtest.sl

import androidx.lifecycle.ViewModel
import com.bbbrrr8877.coremvvmtest.weatherList.presentation.WeatherListViewModel
import com.github.johnnysc.coremvvm.sl.CoreModule
import com.github.johnnysc.coremvvm.sl.DependencyContainer
import com.github.johnnysc.coremvvm.sl.Module

class FeaturesDependencyContainer(
    private val coreModule: CoreModule,
    private val dependencyContainer: DependencyContainer
) : DependencyContainer {


    override fun <T : ViewModel> module(clazz: Class<T>): Module<*> = when (clazz) {
        WeatherListViewModel::class.java -> WeatherModule(
            coreModule,
        )
        else -> dependencyContainer.module(clazz)
    }
}