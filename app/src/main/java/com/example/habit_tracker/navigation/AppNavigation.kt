package com.example.habit_tracker.navigation

import androidx.navigation.compose.NavHost
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.habit_tracker.ui.screens.HabitListScreen
import com.example.habit_tracker.ui.screens.PlantScreen
import com.example.habit_tracker.ui.screens.WeekScreen
import com.example.habit_tracker.viewModel.HabitTrackerViewModel
import com.example.habit_tracker.viewModel.WeatherViewModel

// Here app’s navigation with a NavHost is set up
// WeekScreen (HOME) lets the user select a day, which navigates to HabitListScreen showing habits for that day
// selected day and ViewModel are passed down to HabitListScreen and PlantScreen

// internal route identification names
object Screens {
    const val HOME = "Home"
    const val HABITS = "Habit_list"
    const val PLANT = "Daily_plant"
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
                weatherViewModel = WeatherViewModel(),
                onDaySelected = { day ->
                    navController.navigate("${Screens.HABITS}/$day")
                }
            )
        }

        composable("${Screens.HABITS}/{day}") { backStackEntry ->
            val day = backStackEntry.arguments?.getString("day") ?: "MONDAY"
            HabitListScreen(
                modifier = modifier,
                selectedDay = day,
                navController = navController,
                habitViewModel = habitViewModel
            )
        }
        composable(
            route = "${Screens.PLANT}/{selectedDay}",
           // arguments = listOf(navArgument("selectedDay") { type = NavType.StringType })
        ) { backStackEntry ->
            val day = backStackEntry.arguments?.getString("selectedDay") ?: "MONDAY"
            PlantScreen(
                selectedDay = day,
                habitViewModel = habitViewModel
            )
        }
    }
}
