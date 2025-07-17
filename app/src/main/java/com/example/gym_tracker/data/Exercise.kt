package com.example.gym_tracker.data

data class Exercise(
    val id: String,
    val name: String,
    val description: String,
    val muscleGroups: List<String>,
    val equipment: String?,
    val instructions: List<String>
)