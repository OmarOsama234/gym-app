package com.example.gym_tracker.repository

import com.example.gym_tracker.data.*
import java.util.*

class GymRepository {
    private val exercises = mutableListOf<Exercise>()
    private val workouts = mutableListOf<Workout>()
    private val templates = mutableListOf<WorkoutTemplate>()

    init {
        initializeSampleData()
    }

    private fun initializeSampleData() {
        // Add sample exercises
        exercises.addAll(listOf(
            Exercise(
                id = "ex1",
                name = "Push-ups",
                description = "Classic bodyweight exercise for chest, shoulders, and triceps",
                muscleGroups = listOf("Chest", "Shoulders", "Triceps"),
                equipment = null,
                instructions = listOf(
                    "Start in plank position",
                    "Lower body until chest nearly touches floor",
                    "Push back up to starting position",
                    "Keep core engaged throughout"
                )
            ),
            Exercise(
                id = "ex2",
                name = "Squats",
                description = "Fundamental lower body exercise",
                muscleGroups = listOf("Quadriceps", "Glutes", "Hamstrings"),
                equipment = null,
                instructions = listOf(
                    "Stand with feet shoulder-width apart",
                    "Lower body as if sitting back into a chair",
                    "Keep knees behind toes",
                    "Return to standing position"
                )
            ),
            Exercise(
                id = "ex3",
                name = "Bench Press",
                description = "Classic chest exercise using barbell",
                muscleGroups = listOf("Chest", "Shoulders", "Triceps"),
                equipment = "Barbell",
                instructions = listOf(
                    "Lie on bench with feet flat on floor",
                    "Grip barbell slightly wider than shoulders",
                    "Lower bar to chest",
                    "Press up to full arm extension"
                )
            ),
            Exercise(
                id = "ex4",
                name = "Deadlifts",
                description = "Full body compound exercise",
                muscleGroups = listOf("Hamstrings", "Glutes", "Back", "Traps"),
                equipment = "Barbell",
                instructions = listOf(
                    "Stand with feet hip-width apart",
                    "Bend at hips and knees to grip bar",
                    "Keep back straight, chest up",
                    "Drive through heels to stand up"
                )
            ),
            Exercise(
                id = "ex5",
                name = "Pull-ups",
                description = "Upper body pulling exercise",
                muscleGroups = listOf("Back", "Biceps", "Shoulders"),
                equipment = "Pull-up Bar",
                instructions = listOf(
                    "Hang from bar with palms facing away",
                    "Pull body up until chin over bar",
                    "Lower with control",
                    "Keep core engaged"
                )
            )
        ))

        // Add sample workout templates
        templates.addAll(listOf(
            WorkoutTemplate(
                id = "temp1",
                name = "Upper Body Strength",
                description = "Focus on chest, back, and arms",
                exercises = listOf(exercises[2], exercises[4], exercises[0]), // Bench Press, Pull-ups, Push-ups
                estimatedDuration = 45,
                difficulty = "Intermediate"
            ),
            WorkoutTemplate(
                id = "temp2",
                name = "Lower Body Power",
                description = "Build leg strength and power",
                exercises = listOf(exercises[1], exercises[3]), // Squats, Deadlifts
                estimatedDuration = 30,
                difficulty = "Beginner"
            ),
            WorkoutTemplate(
                id = "temp3",
                name = "Full Body Workout",
                description = "Complete body conditioning",
                exercises = exercises.take(5),
                estimatedDuration = 60,
                difficulty = "Advanced"
            )
        ))
    }

    fun getAllExercises(): List<Exercise> = exercises.toList()

    fun getExerciseById(id: String): Exercise? = exercises.find { it.id == id }

    fun getAllWorkouts(): List<Workout> = workouts.toList()

    fun addWorkout(workout: Workout) {
        workouts.add(workout)
    }

    fun getAllTemplates(): List<WorkoutTemplate> = templates.toList()

    fun getTemplateById(id: String): WorkoutTemplate? = templates.find { it.id == id }

    fun getWorkoutsByDateRange(startDate: Date, endDate: Date): List<Workout> {
        return workouts.filter { it.date >= startDate && it.date <= endDate }
    }

    fun getExercisesByMuscleGroup(muscleGroup: String): List<Exercise> {
        return exercises.filter { it.muscleGroups.contains(muscleGroup) }
    }
}