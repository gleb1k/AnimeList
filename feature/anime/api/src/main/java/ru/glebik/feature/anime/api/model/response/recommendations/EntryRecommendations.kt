package ru.glebik.feature.anime.api.model.response.recommendations


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.glebik.feature.anime.api.model.response.common.image.Images

@Serializable
data class EntryRecommendations(
    @SerialName("mal_id")
    val malId: Int,
    @SerialName("url")
    val url: String?,
    @SerialName("images")
    val images: Images?,
    @SerialName("title")
    val title: String?
)