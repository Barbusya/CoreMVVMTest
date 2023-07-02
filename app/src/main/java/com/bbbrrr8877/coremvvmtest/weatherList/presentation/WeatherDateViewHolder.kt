package com.bbbrrr8877.coremvvmtest.weatherList.presentation

import android.view.View
import com.bbbrrr8877.coremvvmtest.R
import com.github.johnnysc.coremvvm.presentation.adapter.GenericViewHolder
import com.github.johnnysc.coremvvm.presentation.adapter.ItemUi

class WeatherDateViewHolder(view: View) : GenericViewHolder<ItemUi>(view) {

    override fun bind(item: ItemUi) = item.show(itemView.findViewById(R.id.dateTextView))
}