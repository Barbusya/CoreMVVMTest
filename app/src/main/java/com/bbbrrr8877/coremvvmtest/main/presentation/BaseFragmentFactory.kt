package com.bbbrrr8877.coremvvmtest.main.presentation

import androidx.fragment.app.FragmentManager
import com.github.johnnysc.coremvvm.presentation.FragmentFactory
import com.github.johnnysc.coremvvm.presentation.NavigationScreen

class BaseFragmentFactory(
    container: Int,
    fragmentManager: FragmentManager,
) : FragmentFactory.Abstract(
    container,
    fragmentManager
) {

    override val screens: List<NavigationScreen> = listOf(
        //Todo screens
    )
}