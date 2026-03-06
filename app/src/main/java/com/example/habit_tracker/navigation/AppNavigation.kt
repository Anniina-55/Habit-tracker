package com.example.habit_tracker.navigation

import androidx.navigation.compose.NavHost
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.habit_tracker.ui.screens.HabitListScreen
import com.example.habit_tracker.ui.screens.WeekScreen
import com.example.habit_tracker.viewModel.HabitTrackerViewModel

// Here app’s navigation with a NavHost is set up
// WeekScreen (HOME) lets the user select a day, which navigates to HabitListScreen showing habits for that day
// selected day and ViewModel are passed down to HabitListScreen

object Screens {
    const val HOME = "Home"
    const val HABIT_LIST = "Habit list"
}

@Composable
fun AppNavigation(
    navController: NavHostController,
    habitViewModel: HabitTrackerViewModel,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Screens.HOME,
        modifier = modifier
    ) {
        composable(Screens.HOME) {
            WeekScreen(
                modifier = modifier,
                onDaySelected = { day ->
                    navController.navigate("${Screens.HABIT_LIST}/$day")
                }
            )
        }

        composable("${Screens.HABIT_LIST}/{day}") { backStackEntry ->
            val day = backStackEntry.arguments?.getString("day") ?: "MONDAY"
            HabitListScreen(
                modifier = modifier,
                selectedDay = day,
                habitViewModel = habitViewModel
            )
        }
    }
}
