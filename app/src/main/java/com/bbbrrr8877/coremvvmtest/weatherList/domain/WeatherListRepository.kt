package com.bbbrrr8877.coremvvmtest.weatherList.domain

interface WeatherListRepository {

    suspend fun weatherList(): WeatherListDomain
}