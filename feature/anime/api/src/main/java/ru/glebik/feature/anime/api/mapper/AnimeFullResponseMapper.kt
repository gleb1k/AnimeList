package ru.glebik.feature.anime.api.mapper

import ru.glebik.core.utils.mapper.ResponseDomainMapper
import ru.glebik.feature.anime.api.model.domain.AnimeFull
import ru.glebik.feature.anime.api.model.response.animefull.AnimeFullResponse

class AnimeFullResponseMapper : ResponseDomainMapper<AnimeFullResponse, AnimeFull> {
    override fun toDomain(response: AnimeFullResponse): AnimeFull {
        val anime = response.animeFullData ?: return AnimeFull(
            -1,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
        )

        return AnimeFull(
            malId = anime.malId,
            url = anime.url,
            image = anime.images?.jpg?.imageUrl,
            trailerUrl = anime.trailer?.url,

            trailerImage = anime.trailer?.images?.imageUrl,

            approved = anime.approved,
            title = anime.title,
            titleEnglish = anime.titleEnglish,
            type = anime.type,

            source = anime.source,
            episodes = anime.episodes,
            airing = anime.airing,


            rating = anime.rating,
            score = anime.score,
            scoredBy = anime.scoredBy,
            rank = anime.rank,
            popularity = anime.popularity,
            members = anime.members,
            favorites = anime.favorites,
            synopsis = anime.synopsis,
        )
    }

    companion object {
        const val TAG = "AnimeFullResponseMapper"
    }
}