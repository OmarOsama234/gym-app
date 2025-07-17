package com.example.gym_tracker.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gym_tracker.adapters.WorkoutTemplateAdapter
import com.example.gym_tracker.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var templatesAdapter: WorkoutTemplateAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupRecyclerView()
        setupObservers()
        setupClickListeners()

        return root
    }

    private fun setupRecyclerView() {
        templatesAdapter = WorkoutTemplateAdapter(emptyList()) { template ->
            Toast.makeText(context, "Starting ${template.name} workout", Toast.LENGTH_SHORT).show()
            // TODO: Navigate to workout session
        }
        
        binding.templatesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = templatesAdapter
        }
    }

    private fun setupObservers() {
        homeViewModel.workoutTemplates.observe(viewLifecycleOwner) { templates ->
            templatesAdapter.updateTemplates(templates)
        }

        homeViewModel.totalWorkouts.observe(viewLifecycleOwner) { count ->
            binding.totalWorkoutsCount.text = count.toString()
        }

        homeViewModel.weeklyWorkouts.observe(viewLifecycleOwner) { count ->
            binding.weeklyWorkoutsCount.text = count.toString()
        }
    }

    private fun setupClickListeners() {
        binding.startWorkoutButton.setOnClickListener {
            Toast.makeText(context, "Starting new workout", Toast.LENGTH_SHORT).show()
            // TODO: Navigate to workout creation/selection
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}