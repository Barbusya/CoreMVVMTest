package com.bbbrrr8877.coremvvmtest.weatherList.data

import com.bbbrrr8877.coremvvmtest.weatherList.domain.WeatherListDomain
import com.bbbrrr8877.coremvvmtest.weatherList.domain.WeatherListRepository



class BaseWeatherListRepository(
    private val cloudDataSource: WeatherCloudDataSource,
    private val mapper: WeatherCloud.Mapper<WeatherListDomain>
) : WeatherListRepository {

    override suspend fun weatherList(): WeatherListDomain {
        val weatherList = cloudDataSource.latestWeatherList()
        return weatherList.map(mapper)
    }
}

