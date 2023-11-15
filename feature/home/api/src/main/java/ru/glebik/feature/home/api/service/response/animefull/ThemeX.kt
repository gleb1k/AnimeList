package ru.glebik.feature.home.api.service.response.animefull


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ThemeX(
    @SerialName("openings")
    val openings: List<String?>?,
    @SerialName("endings")
    val endings: List<String?>?
)