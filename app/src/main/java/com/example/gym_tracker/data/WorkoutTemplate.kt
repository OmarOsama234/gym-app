package com.example.gym_tracker.data

data class WorkoutTemplate(
    val id: String,
    val name: String,
    val description: String,
    val exercises: List<Exercise>,
    val estimatedDuration: Int, // in minutes
    val difficulty: String // "Beginner", "Intermediate", "Advanced"
)