package com.jcb.chucknorris.presentation.ui.joke

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.jcb.chucknorris.databinding.FragmentJokeBinding
import com.jcb.chucknorris.presentation.ui.main.JokeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JokeFragment : Fragment() {

    private lateinit var binding: FragmentJokeBinding
    private val viewModel: JokeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentJokeBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let { JokeFragmentArgs.fromBundle(it).category }?.let {
            viewModel.loadJoke(it)
        }
    }
}
