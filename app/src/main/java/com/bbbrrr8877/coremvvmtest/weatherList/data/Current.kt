package com.barbusya.android.weatherapp.data

import com.google.gson.annotations.SerializedName

data class Current(
    @SerializedName("last_updated")
    val lastUpdate: String = "",
    @SerializedName("temp_c")
    val temperature: Float = 0f,
    @SerializedName("condition")
    val currentCondition: CurrentCondition,
    @SerializedName("feelslike_c")
    val feelsLike: Float = 0f,
)

data class CurrentCondition(
    @SerializedName("text")
    val currentConditionText: String = "",
    @SerializedName("icon")
    val iconUrl: String = "",

    )