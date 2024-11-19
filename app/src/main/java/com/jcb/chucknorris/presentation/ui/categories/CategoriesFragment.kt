package com.jcb.chucknorris.presentation.ui.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.jcb.chucknorris.databinding.FragmentCategoriesBinding
import com.jcb.chucknorris.presentation.ui.main.JokeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CategoriesFragment : Fragment() {

    private lateinit var binding: FragmentCategoriesBinding
    private val viewModel: JokeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoriesAdapter = CategoriesAdapter { category ->
            findNavController().navigate(
                CategoriesFragmentDirections.actionCategoriesFragmentToJokeFragment(category)
            )
        }

        val viewManager = LinearLayoutManager(requireContext())
        binding.recyclerView.apply {
            setHasFixedSize(true)
            addItemDecoration(DividerItemDecoration(requireContext(), viewManager.orientation))
            layoutManager = viewManager
            adapter = categoriesAdapter
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.categories.collect { categories ->
                    categoriesAdapter().submitList(categories.toList())
                }
            }
        }
    }

    private fun categoriesAdapter() = (binding.recyclerView.adapter as CategoriesAdapter)
}
