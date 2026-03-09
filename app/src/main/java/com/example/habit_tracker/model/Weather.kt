package com.example.habit_tracker.model

data class Weather(
    val temp_c: Double,
    val humidity: Double,
    val wind_kph: Double,
    val condition: WeatherCondition
)

data class WeatherCondition(
    val text: String,
    val icon: String
)