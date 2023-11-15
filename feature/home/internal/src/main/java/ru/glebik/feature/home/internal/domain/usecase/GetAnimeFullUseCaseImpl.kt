package ru.glebik.feature.home.internal.domain.usecase

import ru.glebik.feature.home.api.service.response.animefull.AnimeFullResponse
import ru.glebik.feature.home.api.usecase.GetAnimeFullUseCase

internal class GetAnimeFullUseCaseImpl(

) : GetAnimeFullUseCase{
    override suspend fun invoke(id : Int): AnimeFullResponse {
        TODO("Not yet implemented")
    }
}