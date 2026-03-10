package com.example.habit_tracker.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.habit_tracker.model.Habit
import com.example.habit_tracker.ui.theme.listBackground


// parameters are passed down from HabitListScreen
@Composable
fun HabitList(
    habits: List<Habit>,
    onCheckedChange: (Int, Boolean) -> Unit,
    onHabitDelete: (Int) -> Unit,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier
            .fillMaxWidth()
            .background(
                color = listBackground,
                shape = RoundedCornerShape(16.dp)),
    ) {

       habits.forEach { habit ->

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