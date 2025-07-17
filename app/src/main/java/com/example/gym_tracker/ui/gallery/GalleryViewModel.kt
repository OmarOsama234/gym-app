package com.example.gym_tracker.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gym_tracker.data.Exercise
import com.example.gym_tracker.repository.GymRepository

class GalleryViewModel : ViewModel() {
    private val repository = GymRepository()

    private val _exercises = MutableLiveData<List<Exercise>>()
    val exercises: LiveData<List<Exercise>> = _exercises

    private val _filteredExercises = MutableLiveData<List<Exercise>>()
    val filteredExercises: LiveData<List<Exercise>> = _filteredExercises

    init {
        loadExercises()
    }

    private fun loadExercises() {
        val allExercises = repository.getAllExercises()
        _exercises.value = allExercises
        _filteredExercises.value = allExercises
    }

    fun filterByMuscleGroup(muscleGroup: String?) {
        val allExercises = _exercises.value ?: return
        _filteredExercises.value = if (muscleGroup.isNullOrEmpty() || muscleGroup == "All") {
            allExercises
        } else {
            repository.getExercisesByMuscleGroup(muscleGroup)
        }
    }

    fun searchExercises(query: String) {
        val allExercises = _exercises.value ?: return
        _filteredExercises.value = if (query.isEmpty()) {
            allExercises
        } else {
            allExercises.filter { 
                it.name.contains(query, ignoreCase = true) || 
                it.description.contains(query, ignoreCase = true) 
            }
        }
    }
}