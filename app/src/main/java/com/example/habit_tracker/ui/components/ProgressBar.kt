package com.example.habit_tracker.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.habit_tracker.model.WeekDay
import com.example.habit_tracker.ui.theme.Green
import com.example.habit_tracker.viewModel.HabitTrackerViewModel

@Composable
// gets progress from ViewModel and day from HabitListScreen
fun ShowProgress(
    habitsViewModel: HabitTrackerViewModel,
    selectedDay: WeekDay,
    modifier: Modifier
) {
    val progress = habitsViewModel.getProgressForDay(selectedDay)
    val progressPercent = (progress * 100).toInt() // convert to percent

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        {
            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier
                    .fillMaxWidth(),
                trackColor = Color.LightGray,
                color = Green
            )

            Text(
                text = "$progressPercent%",
                modifier = Modifier.padding(top = 4.dp)
            )
        }
}


