package ru.glebik.feature.anime.api.model.response.animesearch


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.glebik.feature.anime.api.model.response.common.Aired
import ru.glebik.feature.anime.api.model.response.common.Broadcast
import ru.glebik.feature.anime.api.model.response.common.Demographic
import ru.glebik.feature.anime.api.model.response.common.Genre
import ru.glebik.feature.anime.api.model.response.common.Licensor
import ru.glebik.feature.anime.api.model.response.common.Producer
import ru.glebik.feature.anime.api.model.response.common.Studio
import ru.glebik.feature.anime.api.model.response.common.Theme
import ru.glebik.feature.anime.api.model.response.common.Title
import ru.glebik.feature.anime.api.model.response.common.Trailer
import ru.glebik.feature.anime.api.model.response.common.image.Images

@Serializable
data class AnimeSearchResponseItem(
    @SerialName("mal_id")
    val malId: Int,
    @SerialName("url")
    val url: String?,
    @SerialName("images")
    val images: Images?,
    @SerialName("trailer")
    val trailer: Trailer?,
    @SerialName("approved")
    val approved: Boolean?,
    @SerialName("titles")
    val titles: List<Title>?,
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
    val aired: Aired?,
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
    val broadcast: Broadcast?,
    @SerialName("producers")
    val producers: List<Producer>?,
    @SerialName("licensors")
    val licensors: List<Licensor>?,
    @SerialName("studios")
    val studios: List<Studio>?,
    @SerialName("genres")
    val genres: List<Genre>?,
    @SerialName("explicit_genres")
    val explicitGenres: List<String>?,
    @SerialName("themes")
    val themes: List<Theme>?,
    @SerialName("demographics")
    val demographics: List<Demographic>?
)