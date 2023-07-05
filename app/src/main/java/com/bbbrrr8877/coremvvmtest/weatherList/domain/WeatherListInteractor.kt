package com.bbbrrr8877.coremvvmtest.weatherList.domain

import com.bbbrrr8877.coremvvmtest.weatherList.presentation.WeatherListUi
import com.github.johnnysc.coremvvm.core.Dispatchers
import com.github.johnnysc.coremvvm.data.HandleError
import com.github.johnnysc.coremvvm.domain.Interactor

interface WeatherListInteractor {

    suspend fun weatherList(
        atFinish: () -> Unit,
        successful: (WeatherListUi) -> Unit
    )

    class Base(
        private val mapper: WeatherListDomain.Mapper<WeatherListUi>,
        private val repository: WeatherListRepository,
        dispatchers: Dispatchers,
        handleError: HandleError
    ) : Interactor.Abstract(dispatchers, handleError), WeatherListInteractor {

        override suspend fun weatherList(
            atFinish: () -> Unit,
            successful: (WeatherListUi) -> Unit
        ) = handle(successful, atFinish) {
            val data = repository.weatherList()
            return@handle data.map(mapper)
        }
    }
}