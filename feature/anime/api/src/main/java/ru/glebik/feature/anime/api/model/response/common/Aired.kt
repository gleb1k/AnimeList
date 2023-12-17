package ru.glebik.feature.anime.api.model.response.common


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Aired(
    @SerialName("from")
    val from: String?,
    @SerialName("to")
    val to: String?,
    @SerialName("prop")
    val prop: Prop?,
    @SerialName("string")
    val string: String?
)

///////////////
@Serializable
data class Prop(
    @SerialName("from")
    val from: DataFrom?,
    @SerialName("to")
    val dataTo: DataTo?
)

@Serializable
data class DataTo(
    @SerialName("day")
    val day: Int?,
    @SerialName("month")
    val month: Int?,
    @SerialName("year")
    val year: Int?
)

@Serializable
data class DataFrom(
    @SerialName("day")
    val day: Int?,
    @SerialName("month")
    val month: Int?,
    @SerialName("year")
    val year: Int?
)