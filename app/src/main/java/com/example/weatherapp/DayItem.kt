package com.example.weatherapp

import java.util.concurrent.locks.Condition

data class DayItem(
    val city: String,
    val date_weather: String,
    val condition_weather: String,
    val current_temp: String,
    val max_temp: String,
    val min_temp: String,
    val hours: String

)
