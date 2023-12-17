package ru.glebik.feature.anime.api.model.response.common.image


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Jpg(
    @SerialName("image_url")
    val imageUrl: String?,
    @SerialName("small_image_url")
    val smallImageUrl: String?,
    @SerialName("large_image_url")
    val largeImageUrl: String?
)