package com.example.habit_tracker.model

data class Habit(
    val id: Int,
    val habitName: String,
    val day: WeekDay,
    var completed: Boolean = false,
    var deleted: Boolean = false,
)
