package ru.glebik.feature.anime.internal.data.mapper

import ru.glebik.core.utils.mapper.ResponseMapper
import ru.glebik.feature.anime.api.model.domain.AnimeRecommendation
import ru.glebik.feature.anime.api.model.response.recommendations.AnimeRecommendationResponseItem

class AnimeRecommendationResponseMapper :
    ResponseMapper<AnimeRecommendationResponseItem, AnimeRecommendation> {
    override fun toDomain(response: AnimeRecommendationResponseItem): AnimeRecommendation {

        return AnimeRecommendation(
            malId = response.entry.malId,
            title = response.entry.title ?: "",
            image = response.entry.images?.jpg?.imageUrl ?: response.entry.images?.webp?.imageUrl
            ?: ""
        )
    }

    companion object {
        const val TAG = "AnimeRecommendationResponseMapper"
    }
}