package com.example.gym_tracker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gym_tracker.R
import com.example.gym_tracker.data.Workout
import java.text.SimpleDateFormat
import java.util.*

class WorkoutAdapter(
    private var workouts: List<Workout>,
    private val onWorkoutClick: (Workout) -> Unit
) : RecyclerView.Adapter<WorkoutAdapter.ViewHolder>() {

    private val dateFormat = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val workoutName: TextView = view.findViewById(R.id.workoutName)
        val workoutDate: TextView = view.findViewById(R.id.workoutDate)
        val workoutDuration: TextView = view.findViewById(R.id.workoutDuration)
        val exerciseCount: TextView = view.findViewById(R.id.exerciseCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_workout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val workout = workouts[position]
        
        holder.workoutName.text = workout.name
        holder.workoutDate.text = dateFormat.format(workout.date)
        
        val minutes = workout.duration / (1000 * 60)
        holder.workoutDuration.text = "${minutes} min"
        
        holder.exerciseCount.text = "${workout.exercises.size} exercises"

        holder.itemView.setOnClickListener {
            onWorkoutClick(workout)
        }
    }

    override fun getItemCount() = workouts.size

    fun updateWorkouts(newWorkouts: List<Workout>) {
        workouts = newWorkouts
        notifyDataSetChanged()
    }
}