package ru.glebik.feature.anime.api.model.response.common


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.glebik.feature.anime.api.model.response.common.image.ImagesX

@Serializable
data class Trailer(
    @SerialName("youtube_id")
    val youtubeId: String?,
    @SerialName("url")
    val url: String?,
    @SerialName("embed_url")
    val embedUrl: String?,
    @SerialName("images")
    val images: ImagesX?
)