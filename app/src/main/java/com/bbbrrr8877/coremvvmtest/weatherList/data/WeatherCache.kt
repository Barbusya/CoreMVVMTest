package com.bbbrrr8877.coremvvmtest.weatherList.data

interface WeatherCache {

    interface Save : com.github.johnnysc.coremvvm.core.Save<WeatherCloud>

    interface Read : com.github.johnnysc.coremvvm.core.Read<WeatherCloud>

    interface Mutable : Save, Read

    class Base(private var data: WeatherCloud = WeatherCloud.Empty()) : Mutable {

        override fun save(data: WeatherCloud) {
            this.data = data
        }

        override fun read(): WeatherCloud = data
    }

}