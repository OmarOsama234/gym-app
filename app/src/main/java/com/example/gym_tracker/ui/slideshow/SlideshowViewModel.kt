package com.example.gym_tracker.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gym_tracker.data.Workout
import com.example.gym_tracker.repository.GymRepository
import java.util.*

class SlideshowViewModel : ViewModel() {
    private val repository = GymRepository()

    private val _recentWorkouts = MutableLiveData<List<Workout>>()
    val recentWorkouts: LiveData<List<Workout>> = _recentWorkouts

    private val _totalWorkouts = MutableLiveData<Int>()
    val totalWorkouts: LiveData<Int> = _totalWorkouts

    private val _weeklyWorkouts = MutableLiveData<Int>()
    val weeklyWorkouts: LiveData<Int> = _weeklyWorkouts

    private val _monthlyWorkouts = MutableLiveData<Int>()
    val monthlyWorkouts: LiveData<Int> = _monthlyWorkouts

    private val _averageWorkoutDuration = MutableLiveData<Long>()
    val averageWorkoutDuration: LiveData<Long> = _averageWorkoutDuration

    init {
        loadProgressData()
    }

    private fun loadProgressData() {
        val allWorkouts = repository.getAllWorkouts()
        _recentWorkouts.value = allWorkouts.takeLast(5).reversed()
        _totalWorkouts.value = allWorkouts.size

        // Calculate weekly workouts
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, -7)
        val weekAgo = calendar.time
        _weeklyWorkouts.value = repository.getWorkoutsByDateRange(weekAgo, Date()).size

        // Calculate monthly workouts
        calendar.time = Date()
        calendar.add(Calendar.DAY_OF_YEAR, -30)
        val monthAgo = calendar.time
        _monthlyWorkouts.value = repository.getWorkoutsByDateRange(monthAgo, Date()).size

        // Calculate average workout duration
        if (allWorkouts.isNotEmpty()) {
            val totalDuration = allWorkouts.sumOf { it.duration }
            _averageWorkoutDuration.value = totalDuration / allWorkouts.size
        } else {
            _averageWorkoutDuration.value = 0L
        }
    }

    fun refreshData() {
        loadProgressData()
    }
}