package com.bbbrrr8877.coremvvmtest.weatherList.presentation

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bbbrrr8877.coremvvmtest.R
import com.github.johnnysc.coremvvm.presentation.BackPress

class WeatherListFragment : BackPress.Fragment<WeatherListUi, WeatherListViewModel>() {

    override val layoutResId: Int = R.layout.single_recycler_view_layout

    override fun viewModelClass(): Class<WeatherListViewModel> = WeatherListViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val weatherListAdapter = WeatherListAdapter.WeatherList()
        recyclerView.adapter = weatherListAdapter

        viewModel.observe(this) { weatherListUi ->
            weatherListUi.map(weatherListAdapter)
        }
    }
}