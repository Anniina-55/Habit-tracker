package com.example.habit_tracker.viewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.habit_tracker.model.Habit
import com.example.habit_tracker.model.WeekDay

// ViewModel holds the app’s state for habits and provides functions to access and modify them
// this state is shared across screens

class HabitTrackerViewModel : ViewModel() {
    val habits = mutableStateListOf<Habit>()
    fun getHabitsForDay(day: WeekDay): List<Habit> {
        return habits.filter { it.day == day }
    }

    fun toggleHabit(habitId: Int, completed: Boolean) {

        val index = habits.indexOfFirst { it.id == habitId }
        if (index != -1) {
            val habit = habits[index]
            habits[index] = habit.copy(completed = completed) // force Compose re-render
        }

    }
    fun addHabit(habit: Habit) {
            habits.add(habit)
        }
    fun deleteHabit(habitId: Int) {
        habits.removeIf { it.id == habitId }
    }

    fun getProgressForDay(day: WeekDay): Float {
        val dayHabits = getHabitsForDay(day)

        if (dayHabits.isEmpty()) return 0f

        val completed = dayHabits.count { it.completed }

        return completed.toFloat() / dayHabits.size.toFloat()
    }
}