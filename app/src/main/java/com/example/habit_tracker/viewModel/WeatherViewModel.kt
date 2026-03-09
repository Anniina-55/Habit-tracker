package com.example.habit_tracker.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.habit_tracker.model.Weather
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.habit_tracker.network.RetrofitInstance
import com.example.habit_tracker.BuildConfig
import com.example.habit_tracker.model.WeatherCondition
import kotlinx.coroutines.delay
import kotlin.math.round
import kotlin.time.Duration.Companion.minutes

// ViewModel for Weather data
class WeatherViewModel : ViewModel() {
    val weatherToday = mutableStateOf<Weather?>(null)

    init {
        weatherUpdate() //start coroutine to update weather data
    }
    private fun weatherUpdate() {
        // update data automatically in every 30 minutes
        viewModelScope.launch {
            while (true) {
                loadWeatherToday()
                delay(30.minutes)
            }
        }
    }
    private suspend fun loadWeatherToday() {
        // fetch data from API and update state
            try {
                val response = RetrofitInstance.api.getWeather(
                    location = "Oulu, FI",
                    lang = "en",
                    apiKey = BuildConfig.WEATHER_API_KEY // API_key is read from local.properties
                )
                // convert wind speed from km/h to m/s
                val windMs = response.current.wind_kph * 1000 / 3600
                val windMsRounded = (round(windMs * 10) / 10)

                // Weather-object creation
                weatherToday.value = Weather(
                    temp_c = response.current.temp_c,
                    humidity = response.current.humidity,
                    wind_kph = windMsRounded,
                    condition =  WeatherCondition(
                        text = response.current.condition.text,
                        icon = "https:" + response.current.condition.icon
                    )
                )

            // catch errors and replace with default values
            } catch (e: Exception) {
                Log.e("WeatherViewModel", "Failed to fetch weather", e)

                weatherToday.value = Weather(
                    temp_c = 0.0,
                    humidity = 0.0,
                    wind_kph = 0.0,
                    condition = WeatherCondition(
                        text = "Unknown",
                        icon = "unknown"
                    )
                )
            }
        }
    }
