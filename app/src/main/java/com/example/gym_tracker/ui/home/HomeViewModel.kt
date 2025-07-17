package com.example.gym_tracker.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gym_tracker.data.Workout
import com.example.gym_tracker.data.WorkoutTemplate
import com.example.gym_tracker.repository.GymRepository
import java.util.*

class HomeViewModel : ViewModel() {
    private val repository = GymRepository()

    private val _recentWorkouts = MutableLiveData<List<Workout>>()
    val recentWorkouts: LiveData<List<Workout>> = _recentWorkouts

    private val _workoutTemplates = MutableLiveData<List<WorkoutTemplate>>()
    val workoutTemplates: LiveData<List<WorkoutTemplate>> = _workoutTemplates

    private val _totalWorkouts = MutableLiveData<Int>()
    val totalWorkouts: LiveData<Int> = _totalWorkouts

    private val _weeklyWorkouts = MutableLiveData<Int>()
    val weeklyWorkouts: LiveData<Int> = _weeklyWorkouts

    init {
        loadDashboardData()
    }

    private fun loadDashboardData() {
        _workoutTemplates.value = repository.getAllTemplates()
        _recentWorkouts.value = repository.getAllWorkouts().takeLast(3)
        _totalWorkouts.value = repository.getAllWorkouts().size
        
        // Calculate weekly workouts
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, -7)
        val weekAgo = calendar.time
        _weeklyWorkouts.value = repository.getWorkoutsByDateRange(weekAgo, Date()).size
    }

    fun refreshData() {
        loadDashboardData()
    }
}