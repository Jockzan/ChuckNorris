package com.jcb.chucknorris.presentation.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jcb.chucknorris.domain.repository.JokeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JokeViewModel @Inject constructor(private val repository: JokeRepository) : ViewModel() {
    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>> = _categories

    private val _joke = MutableStateFlow<String?>(null)
    val joke: StateFlow<String?> = _joke

    private val _jokeIconUrl = MutableStateFlow<String?>(null)
    val jokeIconUrl: StateFlow<String?> = _jokeIconUrl

    init {
        loadCategories()
    }

    private fun loadCategories() = viewModelScope.launch {
        _categories.value = repository.fetchCategories()
    }

    fun loadJoke(category: String) = viewModelScope.launch {
        val model = repository.fetchJoke(category)
        _joke.value = model.value
        _jokeIconUrl.value = model.iconUrl
    }
}