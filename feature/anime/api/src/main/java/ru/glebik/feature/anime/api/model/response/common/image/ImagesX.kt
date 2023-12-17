package ru.glebik.feature.anime.api.model.response.common.image


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImagesX(
    @SerialName("image_url")
    val imageUrl: String?,
    @SerialName("small_image_url")
    val smallImageUrl: String?,
    @SerialName("medium_image_url")
    val mediumImageUrl: String?,
    @SerialName("large_image_url")
    val largeImageUrl: String?,
    @SerialName("maximum_image_url")
    val maximumImageUrl: String?
)