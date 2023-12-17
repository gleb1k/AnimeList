package ru.glebik.feature.anime.api.model.domain

data class AnimeSearch(
    val malId: Int,
    val url: String?,
    val image: String?,
    val title: String?,
    val titleEnglish: String?,

    val airing: Boolean?,
    val score: Double?,

    val rank: Int?,
    val popularity: Int?,
)