package com.jcb.chucknorris.data.mappers

import com.jcb.chucknorris.data.model.JokeResponse
import com.jcb.chucknorris.domain.model.JokeModel

fun JokeResponse.toJokeModel(): JokeModel {
    return JokeModel(
        categories = categories,
        createdAt = created_at,
        iconUrl = icon_url,
        id = id,
        updatedAt = updated_at,
        url = url,
        value = value
    )
}