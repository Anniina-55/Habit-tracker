package com.example.habit_tracker.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.habit_tracker.model.WeekDay
import com.example.habit_tracker.ui.components.PlantDisplay
import com.example.habit_tracker.ui.components.ShowProgress
import com.example.habit_tracker.viewModel.HabitTrackerViewModel

@Composable
fun PlantScreen(
    selectedDay: String,
    habitViewModel: HabitTrackerViewModel,
    modifier: Modifier = Modifier
) {
    val day = WeekDay.valueOf(selectedDay)
    val progress = habitViewModel.getProgressForDay(day)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        //verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (progress == 1f) {
            Text("Great job with your habits for ${day}!")
        } else {
            Text("Keep going to grow your plant!")
        }
        Spacer(modifier = Modifier.height(8.dp))

        ShowProgress(
            habitViewModel,
            day,
            modifier = modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        PlantDisplay(viewModel = habitViewModel, day = day)
    }
}