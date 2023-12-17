package ru.glebik.feature.anime.api.model.domain

data class AnimeFull(
    val malId: Int,
    val url: String?,
    val image: String?,

    val trailerUrl: String?,
    val trailerImage: String?,

    val approved: Boolean?,

    val title: String?,
    val titleEnglish: String?,
    val type: String?,
    val source: String?,
    val episodes: Int?,
    //ongiong
    val airing: Boolean?,

//    @SerialName("aired")
//    val aired: Aired?,

    val rating: String?,
    val score: Double?,
    val scoredBy: Int?,
    val rank: Int?,
    val popularity: Int?,
    val members: Int?,
    val favorites: Int?,
    val synopsis: String?,

//    @SerialName("background")
//    val background: String?,
//    @SerialName("season")
//    val season: String?,
//    @SerialName("year")
//    val year: Int?,
//    @SerialName("producers")
//    val producers: List<Producer>?,
//    @SerialName("licensors")
//    val licensors: List<Licensor>?,
//    @SerialName("studios")
//    val studios: List<Studio>?,
//    @SerialName("genres")
//    val genres: List<Genre>?,
//    @SerialName("themes")
//    val themes: List<Theme>?,
//    @SerialName("demographics")
//    val demographics: List<Demographic>?,
//    @SerialName("relations")
//    val relations: List<Relation>?,
//    @SerialName("theme")
//    val theme: ThemeX?,
//    @SerialName("external")
//    val external: List<External>?,
//    @SerialName("streaming")
//    val streaming: List<Streaming>?
)
