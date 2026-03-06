package com.example.habit_tracker.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.habit_tracker.model.Habit

// parameters are passed down from HabitListScreen
@Composable
fun HabitList(
    habits: List<Habit>,
    onCheckedChange: (Int, Boolean) -> Unit,
    onHabitDelete: (Int) -> Unit,
    modifier: Modifier = Modifier
) {

    LazyColumn(modifier = modifier) {

        items(habits) { habit ->

            HabitItem(
                habit = habit,
                onChecked = { checked ->
                    onCheckedChange(habit.id, checked) // forward back to HabitListScreen to update
                },
                onDelete = {
                    onHabitDelete(habit.id)
                }
            )
        }

    }
}