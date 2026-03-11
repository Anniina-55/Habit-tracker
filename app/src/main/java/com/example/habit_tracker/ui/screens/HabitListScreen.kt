package com.example.habit_tracker.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.habit_tracker.model.Habit
import com.example.habit_tracker.model.WeekDay
import com.example.habit_tracker.navigation.Screens
import com.example.habit_tracker.ui.components.HabitList
import com.example.habit_tracker.ui.components.ShowProgress
import com.example.habit_tracker.viewModel.HabitTrackerViewModel
import androidx.compose.ui.res.stringResource
import com.example.habit_tracker.R

// here HabitList composable is rendered and list of habits for specific day is fetched through ViewModel
@Composable
fun HabitListScreen(
    selectedDay: String,
    habitViewModel: HabitTrackerViewModel,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var newHabitName by remember { mutableStateOf("") }

    Text(
        text = stringResource(id = R.string.habit_list_title, selectedDay),
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        textAlign = TextAlign.Center
    )

    //Spacer(modifier = Modifier.height(30.dp))

    LazyColumn(
        modifier = modifier.padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                TextField(
                    value = newHabitName,
                    onValueChange = { newHabitName = it },
                    placeholder = { Text(stringResource(id = R.string.text_field_placeholder)) },
                    singleLine = true,
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text
                    ),
                    modifier = Modifier.weight(1f),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFFCF5FD),
                        unfocusedContainerColor = Color(0xFFFCF5FD),
                        focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                        unfocusedIndicatorColor = MaterialTheme.colorScheme.primary
                    )
                )
                Button(
                    onClick = {
                        if (newHabitName.isNotBlank()) {
                            habitViewModel.addHabit(
                                Habit(
                                    habitName = newHabitName,
                                    day = WeekDay.valueOf(selectedDay),
                                    id = habitViewModel.habits.size,
                                    completed = false,
                                    deleted = false)
                            )
                            newHabitName = "" // clear text field
                        }
                    }
                ) {
                    Text(stringResource(id = R.string.add_btn)) // btn label
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            val habitsForDay = habitViewModel.getHabitsForDay(WeekDay.valueOf(selectedDay))
            // onHabitCheckedChange and onHabitDelete are passed down to HabitList so it can modify the data
            HabitList(
                habits = habitsForDay,
                onCheckedChange = { id, completed -> habitViewModel.toggleHabit(id, completed) },
                onHabitDelete = { id -> habitViewModel.deleteHabit(id) },
                modifier = modifier
            )

            Spacer(modifier = Modifier.height(16.dp))

            ShowProgress(
                habitsViewModel = habitViewModel,
                selectedDay = WeekDay.valueOf(selectedDay),
                modifier = modifier.padding(horizontal = 16.dp)
            )

            Button(
                onClick = {
                    // navigates to PlantScreen with selected day as argument
                    navController.navigate("${Screens.PLANT}/$selectedDay")
                },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.secondary,
                        contentColor = Color.Black)
                )
            {
                Text(
                    text = stringResource(id = R.string.plant_screen_nav_btn),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}


