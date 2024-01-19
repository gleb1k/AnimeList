package ru.glebik.feature.anime.internal.data.mapper

import ru.glebik.core.utils.mapper.ResponseMapper
import ru.glebik.feature.anime.api.model.domain.AnimeBaseModel
import ru.glebik.feature.anime.api.model.response.base.AnimeBaseResponseItem

class AnimeBaseResponseMapper : ResponseMapper<AnimeBaseResponseItem, AnimeBaseModel> {
    override fun toDomain(response: AnimeBaseResponseItem): AnimeBaseModel {
        return AnimeBaseModel(
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
        const val TAG = "AnimeBaseResponseMapper"
    }
}