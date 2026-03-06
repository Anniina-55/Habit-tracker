package com.example.habit_tracker.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.habit_tracker.model.Habit

@Composable
// parameters received from HabitList
fun HabitItem(
    modifier: Modifier = Modifier,
    habit: Habit,
    onChecked: (Boolean) -> Unit,
    onDelete: () -> Unit
    )
    {
        Row (
            modifier = modifier
            .padding(12.dp)
            .fillMaxWidth()
            ) {

                Checkbox(
                    checked = habit.completed,
                    onCheckedChange = onChecked
                )
                Text(
                    text = habit.habitName,
                    modifier = Modifier.padding(start = 8.dp)
                )
                Button(onClick = onDelete) {
                    Text("Delete")
                }
            }
    }