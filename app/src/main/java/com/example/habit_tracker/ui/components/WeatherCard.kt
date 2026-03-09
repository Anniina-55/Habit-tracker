package com.example.habit_tracker.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.habit_tracker.model.Weather

@Composable
fun WeatherCard(weather: Weather, modifier: Modifier = Modifier) {

    Card(
        modifier = modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFCFF0FF)),
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Weather",
                modifier = Modifier.padding(bottom = 8.dp),
                fontWeight = FontWeight.Bold
            )
            Text(text = "Temperature is ${weather.temp_c} °C")
            Text(text = "Humidity is ${weather.humidity} %")
            Text(text = "Wind speed is ${weather.wind_kph} m/s")
            Text(text = weather.condition.text)
            Image(
                painter = rememberAsyncImagePainter("https:" + weather.condition.icon),
                contentDescription = weather.condition.text,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(64.dp)
            )
        }
    }
}