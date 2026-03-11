package com.example.habit_tracker.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.habit_tracker.model.Weather
import androidx.compose.ui.res.stringResource
import com.example.habit_tracker.R

@Composable
fun WeatherCard(weather: Weather, modifier: Modifier = Modifier) {

    val weatherTextStyle = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.sp, color = Color.Black)

    Card(
        modifier = modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary),
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = stringResource(id = R.string.weather_title),
                modifier = Modifier.padding(8.dp),
                fontWeight = FontWeight.Bold,
                style = weatherTextStyle
            )
            Text(text = stringResource(R.string.temperature, weather.temp_c), style = weatherTextStyle)
            Text(text = stringResource(R.string.humidity, weather.humidity), style = weatherTextStyle)
            Text(text = stringResource(R.string.wind_speed, weather.wind_kph), style = weatherTextStyle)
            Text(text = stringResource(R.string.condition, weather.condition.text), style = weatherTextStyle)
            Image(
                painter = rememberAsyncImagePainter(weather.condition.icon),
                contentDescription = weather.condition.text,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(64.dp)
            )
        }
    }
}