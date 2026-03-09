package com.example.habit_tracker.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.habit_tracker.model.WeekDay
import com.example.habit_tracker.ui.components.WeatherCard
import com.example.habit_tracker.viewModel.WeatherViewModel
import java.time.format.DateTimeFormatter
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import java.time.LocalDate

@Composable
// renders buttons for each day of the week and passes the selected day to HabitListScreen
fun WeekScreen(
    modifier: Modifier = Modifier,
    onDaySelected: (String) -> Unit,
    weatherViewModel: WeatherViewModel
) {
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
    val today = LocalDate.now()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Welcome! ✨",
            modifier = Modifier.padding(bottom = 16.dp),
            style = MaterialTheme.typography.titleLarge,
        )
        Text(
            text = "Today is ${today.format(formatter)}",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 12.dp)
        )


        weatherViewModel.weatherToday.value?.let { weather ->
            WeatherCard(weather = weather)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Select day to set and track your habits",
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )
        val days = WeekDay.entries // from WeekDay model

        // render two buttons per row, so iteration is done in groups of 2
        for (i in days.indices step 2) {
            Row(
                modifier = Modifier.padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                // button label is the name of the day
                Button(onClick = { onDaySelected(days[i].name) }) {
                    Text(days[i].name)
                }

                if (i + 1 < days.size) {

                    Spacer(modifier = Modifier.width(8.dp)) // little space between btns

                    Button(onClick = { onDaySelected(days[i + 1].name) }) {
                        Text(days[i + 1].name)
                    }
                }
            }
        }
    }
}