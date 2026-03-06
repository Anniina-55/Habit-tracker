package com.example.habit_tracker.model

import java.time.LocalDate

data class Weather(
    val date: LocalDate,
    val temperature: Double,
    val humidity: Double,
    val windSpeed: Double,
)
