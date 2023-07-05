package com.bbbrrr8877.coremvvmtest.weatherList.data

import com.github.johnnysc.coremvvm.data.CloudDataSource
import com.github.johnnysc.coremvvm.data.HandleError

interface WeatherCloudDataSource {

    suspend fun latestWeatherList(): WeatherCloud

    class Base(
        private val weatherService: WeatherService,
        handleError: HandleError,
    ) : CloudDataSource.Abstract(handleError), WeatherCloudDataSource {

        override suspend fun latestWeatherList() = handle {
            weatherService.weatherList()
        }
    }
}