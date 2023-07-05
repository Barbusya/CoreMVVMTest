package com.bbbrrr8877.coremvvmtest.sl

import android.util.Log
import com.bbbrrr8877.coremvvmtest.weatherList.data.*
import com.bbbrrr8877.coremvvmtest.weatherList.domain.WeatherListDomain
import com.bbbrrr8877.coremvvmtest.weatherList.domain.WeatherListInteractor
import com.bbbrrr8877.coremvvmtest.weatherList.presentation.WeatherListCommunication
import com.bbbrrr8877.coremvvmtest.weatherList.presentation.WeatherListViewModel
import com.github.johnnysc.coremvvm.domain.HandleDomainError
import com.github.johnnysc.coremvvm.presentation.HandleUiError
import com.github.johnnysc.coremvvm.sl.CoreModule
import com.github.johnnysc.coremvvm.sl.Module


class WeatherModule(
    private val coreModule: CoreModule,
) : Module<WeatherListViewModel> {

    override fun viewModel(): WeatherListViewModel {
        val repository = BaseWeatherListRepository(
            WeatherCloudDataSource.Base(
                ProvideWeatherService.Base(coreModule).weatherService(),
                HandleDomainError()
            ),
            WeatherCloud.Mapper.Base()
        )
        return WeatherListViewModel(
            coreModule.provideCanGoBack(),
            WeatherListInteractor.Base(
                WeatherListDomain.Mapper.Base(),
                repository,
                coreModule.dispatchers(),
                HandleUiError(coreModule, coreModule.provideGlobalErrorCommunication())
            ),
            coreModule.provideProgressCommunication(),
            WeatherListCommunication.Base(),
            coreModule.dispatchers()
        )
    }
}