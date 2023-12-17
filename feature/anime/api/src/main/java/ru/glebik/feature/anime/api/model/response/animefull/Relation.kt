package ru.glebik.feature.anime.api.model.response.animefull


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.glebik.feature.anime.api.model.response.common.Entry

@Serializable
data class Relation(
    @SerialName("relation")
    val relation: String?,
    @SerialName("entry")
    val entry: List<Entry?>?
)