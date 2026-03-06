package com.example.habit_tracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.habit_tracker.navigation.AppNavigation
import com.example.habit_tracker.ui.theme.HabittrackerTheme
import com.example.habit_tracker.viewModel.HabitTrackerViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HabittrackerTheme {
                val navController = rememberNavController() // initialize NavController
                val habitTrackerViewModel: HabitTrackerViewModel =
                    viewModel() //and initialize ViewModel

                Scaffold(
                    topBar = {
                        TopAppBar(title = { Text("Habit tracker") })
                    }
                ) { paddingValues ->
                    AppNavigation(
                        navController = navController,
                        habitViewModel = habitTrackerViewModel,
                        modifier = Modifier.padding(paddingValues)
                    )
                }
            }
        }
    }
}