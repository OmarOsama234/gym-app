package com.example.gym_tracker.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gym_tracker.adapters.WorkoutAdapter
import com.example.gym_tracker.databinding.FragmentSlideshowBinding

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null
    private lateinit var slideshowViewModel: SlideshowViewModel
    private lateinit var workoutAdapter: WorkoutAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        slideshowViewModel = ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupRecyclerView()
        setupObservers()

        return root
    }

    private fun setupRecyclerView() {
        workoutAdapter = WorkoutAdapter(emptyList()) { workout ->
            // TODO: Navigate to workout details
        }
        
        binding.recentWorkoutsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = workoutAdapter
        }
    }

    private fun setupObservers() {
        slideshowViewModel.recentWorkouts.observe(viewLifecycleOwner) { workouts ->
            workoutAdapter.updateWorkouts(workouts)
            binding.noWorkoutsText.visibility = if (workouts.isEmpty()) View.VISIBLE else View.GONE
        }

        slideshowViewModel.totalWorkouts.observe(viewLifecycleOwner) { count ->
            binding.totalWorkoutsText.text = count.toString()
        }

        slideshowViewModel.weeklyWorkouts.observe(viewLifecycleOwner) { count ->
            binding.weeklyWorkoutsText.text = count.toString()
        }

        slideshowViewModel.monthlyWorkouts.observe(viewLifecycleOwner) { count ->
            binding.monthlyWorkoutsText.text = count.toString()
        }

        slideshowViewModel.averageWorkoutDuration.observe(viewLifecycleOwner) { duration ->
            val minutes = duration / (1000 * 60) // Convert milliseconds to minutes
            binding.avgDurationText.text = "${minutes} min"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}