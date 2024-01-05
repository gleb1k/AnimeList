package ru.glebik.feature.anime.internal.data.mapper

import ru.glebik.core.utils.mapper.ResponseMapper
import ru.glebik.feature.anime.api.model.domain.AnimeSearch
import ru.glebik.feature.anime.api.model.response.animesearch.AnimeSearchResponseItem

class AnimeSearchResponseMapper : ResponseMapper<AnimeSearchResponseItem, AnimeSearch> {
    override fun toDomain(response: AnimeSearchResponseItem): AnimeSearch {
        return AnimeSearch(
            malId = response.malId,
            url = response.url,
            image = response.images?.jpg?.imageUrl,
            title = response.title,
            titleEnglish = response.titleEnglish,
            airing = response.airing,
            score = response.score,
            rank = response.rank,
            popularity = response.popularity,
        )
    }

    companion object {
        const val TAG = "AnimeSearchResponseMapper"
    }
}