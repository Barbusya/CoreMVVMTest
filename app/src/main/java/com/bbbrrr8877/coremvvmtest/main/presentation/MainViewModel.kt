package com.bbbrrr8877.coremvvmtest.main.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.github.johnnysc.coremvvm.core.Dispatchers
import com.github.johnnysc.coremvvm.presentation.*

class MainViewModel(
    canGoBack: CanGoBack,
    private val progressCommunication: ProgressCommunication.Mutable,
    dispatchers: Dispatchers,
    communication: GlobalErrorCommunication.Mutable
) : BackPress.Activity.ViewModel<String>(
    canGoBack,
    communication,
    dispatchers
) {

    fun observeProgress(owner: LifecycleOwner, observer: Observer<Visibility>) {
        progressCommunication.observe(owner, observer)
    }
}