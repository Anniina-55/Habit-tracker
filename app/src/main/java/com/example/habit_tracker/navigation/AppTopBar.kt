package com.example.habit_tracker.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.material3.ExperimentalMaterial3Api

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(navController: NavController ) {

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route
    val showBack = currentRoute != Screens.HOME

    // set title dynamically based on the current route
    val title = when {
        currentRoute == Screens.HOME -> "Habit tracker"
        currentRoute == "${Screens.HABITS}/{day}" -> "Habit list"
        currentRoute == "${Screens.PLANT}/{selectedDay}" -> "Daily plant"
        else -> "Habit tracker"
    }

    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            if (showBack) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        }
    )
}
