package com.jcb.chucknorris.data.repository

import com.jcb.chucknorris.data.api.ApiService
import com.jcb.chucknorris.data.mappers.toJokeModel
import com.jcb.chucknorris.domain.model.JokeModel
import com.jcb.chucknorris.domain.repository.JokeRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class JokeRepositoryImpl
@Inject constructor(
    private val apiService: ApiService
) : JokeRepository {

    override suspend fun fetchCategories(): List<String> {
        return apiService.getCategories()
    }

    override suspend fun fetchJoke(category: String): JokeModel =
        apiService.getJoke(category).toJokeModel()

}
