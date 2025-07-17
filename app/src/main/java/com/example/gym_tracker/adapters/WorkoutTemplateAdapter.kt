package com.example.gym_tracker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gym_tracker.R
import com.example.gym_tracker.data.WorkoutTemplate

class WorkoutTemplateAdapter(
    private var templates: List<WorkoutTemplate>,
    private val onTemplateClick: (WorkoutTemplate) -> Unit
) : RecyclerView.Adapter<WorkoutTemplateAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val templateName: TextView = view.findViewById(R.id.templateName)
        val templateDescription: TextView = view.findViewById(R.id.templateDescription)
        val templateDuration: TextView = view.findViewById(R.id.templateDuration)
        val templateDifficulty: TextView = view.findViewById(R.id.templateDifficulty)
        val exerciseCount: TextView = view.findViewById(R.id.exerciseCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_workout_template, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val template = templates[position]
        
        holder.templateName.text = template.name
        holder.templateDescription.text = template.description
        holder.templateDuration.text = "${template.estimatedDuration} min"
        holder.templateDifficulty.text = template.difficulty
        holder.exerciseCount.text = "${template.exercises.size} exercises"

        holder.itemView.setOnClickListener {
            onTemplateClick(template)
        }
    }

    override fun getItemCount() = templates.size

    fun updateTemplates(newTemplates: List<WorkoutTemplate>) {
        templates = newTemplates
        notifyDataSetChanged()
    }
}