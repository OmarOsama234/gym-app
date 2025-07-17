package com.example.gym_tracker.ui.gallery

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gym_tracker.adapters.ExerciseAdapter
import com.example.gym_tracker.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private lateinit var galleryViewModel: GalleryViewModel
    private lateinit var exerciseAdapter: ExerciseAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        galleryViewModel = ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupRecyclerView()
        setupObservers()
        setupSearch()
        setupFilters()

        return root
    }

    private fun setupRecyclerView() {
        exerciseAdapter = ExerciseAdapter(emptyList()) { exercise ->
            Toast.makeText(context, "Selected: ${exercise.name}", Toast.LENGTH_SHORT).show()
            // TODO: Navigate to exercise details or add to workout
        }
        
        binding.exercisesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = exerciseAdapter
        }
    }

    private fun setupObservers() {
        galleryViewModel.filteredExercises.observe(viewLifecycleOwner) { exercises ->
            exerciseAdapter.updateExercises(exercises)
        }
    }

    private fun setupSearch() {
        binding.searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                galleryViewModel.searchExercises(s?.toString() ?: "")
            }
        })
    }

    private fun setupFilters() {
        binding.chipAll.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                clearOtherChips()
                galleryViewModel.filterByMuscleGroup(null)
            }
        }

        binding.chipChest.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                clearOtherChips(binding.chipChest.id)
                galleryViewModel.filterByMuscleGroup("Chest")
            }
        }

        binding.chipBack.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                clearOtherChips(binding.chipBack.id)
                galleryViewModel.filterByMuscleGroup("Back")
            }
        }

        binding.chipLegs.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                clearOtherChips(binding.chipLegs.id)
                galleryViewModel.filterByMuscleGroup("Quadriceps")
            }
        }

        binding.chipShoulders.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                clearOtherChips(binding.chipShoulders.id)
                galleryViewModel.filterByMuscleGroup("Shoulders")
            }
        }

        binding.chipArms.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                clearOtherChips(binding.chipArms.id)
                galleryViewModel.filterByMuscleGroup("Biceps")
            }
        }
    }

    private fun clearOtherChips(exceptId: Int = -1) {
        val chips = listOf(
            binding.chipAll, binding.chipChest, binding.chipBack,
            binding.chipLegs, binding.chipShoulders, binding.chipArms
        )
        
        chips.forEach { chip ->
            if (chip.id != exceptId) {
                chip.isChecked = false
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}