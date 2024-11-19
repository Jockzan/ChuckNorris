package com.jcb.chucknorris.domain.repository

import com.jcb.chucknorris.domain.model.JokeModel

interface JokeRepository {
    suspend fun fetchCategories(): List<String>
    suspend fun fetchJoke(category: String): JokeModel
}