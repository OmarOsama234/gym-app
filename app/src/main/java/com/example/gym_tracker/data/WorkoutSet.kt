package com.example.gym_tracker.data

data class WorkoutSet(
    val id: String,
    val exerciseId: String,
    val reps: Int,
    val weight: Double,
    val restTime: Int?, // in seconds
    val completed: Boolean = false
)