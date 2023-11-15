package ru.glebik.feature.home.api.service.response.animefull


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Relation(
    @SerialName("relation")
    val relation: String?,
    @SerialName("entry")
    val entry: List<ru.glebik.feature.home.api.service.response.animefull.Entry?>?
)