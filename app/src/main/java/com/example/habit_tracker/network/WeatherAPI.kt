package com.example.habit_tracker.network

import com.example.habit_tracker.model.Weather
import retrofit2.http.GET
import retrofit2.http.Query

data class WeatherResponse(
    val current: Weather
)

interface WeatherAPIService {
    @GET("current.json") // endpoint
    suspend fun getWeather(
        @Query("key") apiKey: String,
        //@Query("q") city: String,
        @Query("q") location: String,
        @Query("lang") lang: String
    ): WeatherResponse
}