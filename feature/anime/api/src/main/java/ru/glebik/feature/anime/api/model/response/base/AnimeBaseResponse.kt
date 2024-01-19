package ru.glebik.feature.anime.api.model.response.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.glebik.feature.anime.api.model.response.common.pagination.Pagination

/*
    Base search anime response (search, seasons, top)
 */
@Serializable
data class AnimeBaseResponse(
    @SerialName("pagination")
    val pagination: Pagination?,
    @SerialName("data")
    val list: List<AnimeBaseResponseItem>?
)