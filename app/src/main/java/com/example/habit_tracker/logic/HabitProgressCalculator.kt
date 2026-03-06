package com.example.habit_tracker.logic

fun calculateProgress(doneHabits: Int, totalHabits: Int): Int {
    return (doneHabits * 100) / totalHabits
}