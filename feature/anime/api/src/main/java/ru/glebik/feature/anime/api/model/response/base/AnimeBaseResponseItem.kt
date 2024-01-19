package ru.glebik.feature.anime.api.model.response.base

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
data class AnimeBaseResponseItem(
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
// CONTAINS:

//"data": [
//{
//    "mal_id": 0,
//    "url": "string",
//    "images": {},
//    "trailer": {},
//    "approved": true,
//    "titles": [],
//    "title": "string",
//    "title_english": "string",
//    "title_japanese": "string",
//    "title_synonyms": [],
//    "type": "TV",
//    "source": "string",
//    "episodes": 0,
//    "status": "Finished Airing",
//    "airing": true,
//    "aired": {},
//    "duration": "string",
//    "rating": "G - All Ages",
//    "score": 0,
//    "scored_by": 0,
//    "rank": 0,
//    "popularity": 0,
//    "members": 0,
//    "favorites": 0,
//    "synopsis": "string",
//    "background": "string",
//    "season": "summer",
//    "year": 0,
//    "broadcast": {},
//    "producers": [],
//    "licensors": [],
//    "studios": [],
//    "genres": [],
//    "explicit_genres": [],
//    "themes": [],
//    "demographics": []
//}
//],