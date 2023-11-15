package ru.glebik.feature.home.api.service.response.animefull


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimeFullData(
    @SerialName("mal_id")
    val malId: Int?,
    @SerialName("url")
    val url: String?,
    @SerialName("images")
    val images: ru.glebik.feature.home.api.service.response.animefull.Images?,
    @SerialName("trailer")
    val trailer: ru.glebik.feature.home.api.service.response.animefull.Trailer?,
    @SerialName("approved")
    val approved: Boolean?,
    @SerialName("titles")
    val titles: List<ru.glebik.feature.home.api.service.response.animefull.Title>?,
    @SerialName("title")
    val title: String?,
    @SerialName("title_english")
    val titleEnglish: String?,
    @SerialName("title_japanese")
    val titleJapanese: String?,
    @SerialName("title_synonyms")
    val titleSynonyms: List<String>?,
    @SerialName("type")
    val type: String?,
    @SerialName("source")
    val source: String?,
    @SerialName("episodes")
    val episodes: Int?,
    @SerialName("status")
    val status: String?,
    @SerialName("airing")
    val airing: Boolean?,
    @SerialName("aired")
    val aired: ru.glebik.feature.home.api.service.response.animefull.Aired?,
    @SerialName("duration")
    val duration: String?,
    @SerialName("rating")
    val rating: String?,
    @SerialName("score")
    val score: Double?,
    @SerialName("scored_by")
    val scoredBy: Int?,
    @SerialName("rank")
    val rank: Int?,
    @SerialName("popularity")
    val popularity: Int?,
    @SerialName("members")
    val members: Int?,
    @SerialName("favorites")
    val favorites: Int?,
    @SerialName("synopsis")
    val synopsis: String?,
    @SerialName("background")
    val background: String?,
    @SerialName("season")
    val season: String?,
    @SerialName("year")
    val year: Int?,
    @SerialName("broadcast")
    val broadcast: ru.glebik.feature.home.api.service.response.animefull.Broadcast?,
    @SerialName("producers")
    val producers: List<ru.glebik.feature.home.api.service.response.animefull.Producer>?,
    @SerialName("licensors")
    val licensors: List<ru.glebik.feature.home.api.service.response.animefull.Licensor>?,
    @SerialName("studios")
    val studios: List<ru.glebik.feature.home.api.service.response.animefull.Studio>?,
    @SerialName("genres")
    val genres: List<ru.glebik.feature.home.api.service.response.animefull.Genre>?,
//    @SerialName("explicit_genres")
//    val explicitGenres: List<Any>?,
    @SerialName("themes")
    val themes: List<ru.glebik.feature.home.api.service.response.animefull.Theme>?,
    @SerialName("demographics")
    val demographics: List<ru.glebik.feature.home.api.service.response.animefull.Demographic>?,
    @SerialName("relations")
    val relations: List<ru.glebik.feature.home.api.service.response.animefull.Relation>?,
    @SerialName("theme")
    val theme: ru.glebik.feature.home.api.service.response.animefull.ThemeX?,
    @SerialName("external")
    val `external`: List<ru.glebik.feature.home.api.service.response.animefull.External>?,
    @SerialName("streaming")
    val streaming: List<ru.glebik.feature.home.api.service.response.animefull.Streaming>?
)