package com.bbbrrr8877.coremvvmtest.weatherList.presentation

import android.view.View
import com.bbbrrr8877.coremvvmtest.R
import com.github.johnnysc.coremvvm.presentation.adapter.GenericViewHolder
import com.github.johnnysc.coremvvm.presentation.adapter.ItemUi

class WeatherViewHolder(view: View) : GenericViewHolder<ItemUi>(view) {

    override fun bind(item: ItemUi) = with(itemView) {
        item.show(
            findViewById(R.id.weatherTextView),
            findViewById(R.id.imageView)
        )
    }

}