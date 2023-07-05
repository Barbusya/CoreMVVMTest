package com.bbbrrr8877.coremvvmtest.weatherList.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bbbrrr8877.coremvvmtest.R
import com.github.johnnysc.coremvvm.presentation.adapter.GenericViewHolder
import com.github.johnnysc.coremvvm.presentation.adapter.ItemUi
import com.github.johnnysc.coremvvm.presentation.adapter.ViewHolderFactoryChain

class WeatherDateViewHolderChain(
    private val viewHolderFactoryChain: ViewHolderFactoryChain<ItemUi>
) : ViewHolderFactoryChain<ItemUi> {

    override fun viewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<ItemUi> =
        if (viewType == 2)
            WeatherDateViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.weather_date_layout, parent, false)
            )
        else viewHolderFactoryChain.viewHolder(parent, viewType)

}