package ru.glebik.feature.home.internal.presentation.viewmodel

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.anime.api.model.domain.AnimeBaseModel
import ru.glebik.feature.anime.api.model.domain.AnimeRecommendation
import ru.glebik.feature.anime.api.usecase.GetAnimeRecommendationsUseCase
import ru.glebik.feature.anime.api.usecase.GetAnimeSeasonNowUseCase
import ru.glebik.feature.anime.api.usecase.GetTopAnimeByScoreUseCase

internal class HomeStoreFactory(
    private val storeFactory: StoreFactory,
    private val getAnimeRecommendationsUseCase: GetAnimeRecommendationsUseCase,
    private val getAnimeSeasonNowUseCase: GetAnimeSeasonNowUseCase,
    private val getTopAnimeByScoreUseCase: GetTopAnimeByScoreUseCase,
) {
    fun create(): HomeStore = object :
        HomeStore,
        Store<HomeStore.Intent, HomeStore.State, HomeStore.Label> by storeFactory.create(
            name = HomeStore::class.simpleName,
            initialState = HomeStore.State(),
            bootstrapper = null,
            executorFactory = {
                HomeExecutor(
                    getAnimeRecommendationsUseCase,
                    getAnimeSeasonNowUseCase,
                    getTopAnimeByScoreUseCase
                )
            },
            reducer = HomeReducer(),
        ) {}

    sealed interface Message {
        data object SetLoading : Message
        data class SetRecommendations(
            val recommendationsList: List<AnimeRecommendation>
        ) : Message

        data class SetSeasonNow(
            val list: List<AnimeBaseModel>
        ) : Message

        data class SetTopByScore(
            val list: List<AnimeBaseModel>
        ) : Message

        data class SetError(val error: ResultWrapper.Failed) : Message
    }
}