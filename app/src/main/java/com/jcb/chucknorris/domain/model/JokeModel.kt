package com.jcb.chucknorris.domain.model

data class JokeModel(
    val categories: List<String>,
    val createdAt: String,
    val iconUrl: String,
    val id: String,
    val updatedAt: String,
    val url: String,
    val value: String
)
