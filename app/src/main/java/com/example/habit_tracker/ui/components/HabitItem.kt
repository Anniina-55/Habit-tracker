package com.example.habit_tracker.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.habit_tracker.model.Habit
import androidx.compose.ui.res.stringResource
import com.example.habit_tracker.R

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
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
            ) {

                Checkbox(
                    checked = habit.completed,
                    onCheckedChange = onChecked,
                    colors = CheckboxDefaults.colors(
                        checkedColor = MaterialTheme.colorScheme.primary,
                        uncheckedColor = MaterialTheme.colorScheme.primary,
                        checkmarkColor = Color.White
                    )
                )
                Text(
                    text = habit.habitName,
                    modifier = Modifier.padding(start = 8.dp),
                    fontWeight = FontWeight.Bold
                )

            Spacer(modifier = Modifier.weight(1f)) // fills middle part and pushes button to right

                Button(
                    onClick = onDelete,
                    modifier = Modifier.padding(end = 8.dp),
                ) {
                    Text(stringResource(id = R.string.delete_btn))
                }
            }
    }