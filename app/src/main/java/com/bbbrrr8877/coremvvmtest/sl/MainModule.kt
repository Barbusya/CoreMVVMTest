package com.bbbrrr8877.coremvvmtest.sl

import com.bbbrrr8877.coremvvmtest.main.presentation.MainViewModel
import com.github.johnnysc.coremvvm.sl.CoreModule
import com.github.johnnysc.coremvvm.sl.Module

class MainModule(private val coreModule: CoreModule) : Module<MainViewModel> {

    override fun viewModel() = MainViewModel(
        coreModule.provideCanGoBack(),
        coreModule.provideProgressCommunication(),
        coreModule.dispatchers(),
        coreModule.provideGlobalErrorCommunication(),
    )

}