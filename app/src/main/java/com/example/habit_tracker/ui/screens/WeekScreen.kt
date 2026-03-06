package com.example.habit_tracker.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.habit_tracker.model.WeekDay

@Composable
// renders buttons for each day of the week and passes the selected day to HabitListScreen
fun WeekScreen(
    modifier: Modifier = Modifier,
    onDaySelected: (String) -> Unit) {

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Select day",
            modifier = Modifier.padding(bottom = 16.dp)
        )
        WeekDay.entries.forEach { day ->
            Button(
                onClick = { onDaySelected(day.name) },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = day.name,
                    modifier = Modifier.padding(8.dp)
                )
              }
        }
    }
}
