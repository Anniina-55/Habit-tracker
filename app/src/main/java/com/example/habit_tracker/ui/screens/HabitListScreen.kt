package com.example.habit_tracker.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.habit_tracker.model.Habit
import com.example.habit_tracker.model.WeekDay
import com.example.habit_tracker.ui.components.HabitList
import com.example.habit_tracker.viewModel.HabitTrackerViewModel

// here HabitList composable is rendered and list of habits for specific day is fetched through ViewModel
@Composable
fun HabitListScreen(
    selectedDay: String,
    habitViewModel: HabitTrackerViewModel,
    modifier: Modifier = Modifier
) {
    var newHabitName by remember { mutableStateOf("") }

    Column(modifier = modifier.padding(16.dp)) {
        Text(text = "Your habits for $selectedDay")

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)) {

            TextField(
                value = newHabitName,
                onValueChange = { newHabitName = it },
                placeholder = { Text("Enter new habit") },
                singleLine = true,
                maxLines = 1,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text
                ),
                modifier = Modifier.weight(1f)
            )
            Button(
                onClick = {
                    if (newHabitName.isNotBlank()) {
                        habitViewModel.addHabit(Habit(
                            habitName = newHabitName,
                            day = WeekDay.valueOf(selectedDay),
                            id = habitViewModel.habits.size,
                            completed = false,
                            deleted = false
                        ))
                        newHabitName = ""
                    }
                }
            ) {
                Text("Add")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        val habitsForDay = habitViewModel.getHabitsForDay(WeekDay.valueOf(selectedDay))
        // onHabitCheckedChange and onHabitDelete are passed down to HabitList so it can modify the data
        HabitList(
            habits = habitsForDay,
            onCheckedChange = { id, completed -> habitViewModel.toggleHabit(id, completed) },
            onHabitDelete = { id -> habitViewModel.deleteHabit(id) },
            modifier = modifier
        )
    }
}