package com.example.gym_tracker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gym_tracker.R
import com.example.gym_tracker.data.Exercise

class ExerciseAdapter(
    private var exercises: List<Exercise>,
    private val onExerciseClick: (Exercise) -> Unit
) : RecyclerView.Adapter<ExerciseAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val exerciseName: TextView = view.findViewById(R.id.exerciseName)
        val exerciseDescription: TextView = view.findViewById(R.id.exerciseDescription)
        val muscleGroups: TextView = view.findViewById(R.id.muscleGroups)
        val equipment: TextView = view.findViewById(R.id.equipment)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_exercise, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val exercise = exercises[position]
        
        holder.exerciseName.text = exercise.name
        holder.exerciseDescription.text = exercise.description
        holder.muscleGroups.text = exercise.muscleGroups.joinToString(", ")
        holder.equipment.text = exercise.equipment ?: "Bodyweight"

        holder.itemView.setOnClickListener {
            onExerciseClick(exercise)
        }
    }

    override fun getItemCount() = exercises.size

    fun updateExercises(newExercises: List<Exercise>) {
        exercises = newExercises
        notifyDataSetChanged()
    }
}