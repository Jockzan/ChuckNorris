package com.jcb.chucknorris.data.di

import com.jcb.chucknorris.data.api.ApiService
import com.jcb.chucknorris.data.repository.JokeRepositoryImpl
import com.jcb.chucknorris.domain.repository.JokeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideJokeRepository(apiService: ApiService): JokeRepository {
        return JokeRepositoryImpl(apiService)
    }

}