package com.example.weatherapp.adapters

// массив для заполнения данных после парсинга
data class WeatherModel(
    val city: String,
    val date_weather: String,
    val condition_weather: String,
    val current_temp: String,
    val max_temp: String,
    val min_temp: String,
    val hours: String
)