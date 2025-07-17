package com.example.gym_tracker.data

import java.util.Date

data class Workout(
    val id: String,
    val name: String,
    val date: Date,
    val exercises: List<Exercise>,
    val sets: List<WorkoutSet>,
    val duration: Long, // in milliseconds
    val notes: String?
)