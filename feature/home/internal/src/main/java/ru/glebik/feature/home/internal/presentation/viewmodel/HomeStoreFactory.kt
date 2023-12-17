package ru.glebik.feature.home.internal.presentation.viewmodel

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.anime.api.model.domain.AnimeRecommendation
import ru.glebik.feature.anime.api.usecase.GetAnimeRecommendationsUseCase

internal class HomeStoreFactory(
    private val storeFactory: StoreFactory,
    private val getAnimeRecommendationsUseCase: GetAnimeRecommendationsUseCase,
) {
    fun create(): HomeStore = object :
        HomeStore,
        Store<HomeStore.Intent, HomeStore.State, HomeStore.Label> by storeFactory.create(
            name = HomeStore::class.simpleName,
            initialState = HomeStore.State(),
            bootstrapper = null,
            executorFactory = {
                HomeExecutor(
                    getAnimeRecommendationsUseCase
                )
            },
            reducer = HomeReducer(),
        ) {}

    sealed interface Message {
        data object SetLoading : Message
        data class SetRecommendations(
            val recommendationsList: List<AnimeRecommendation>
        ) : Message

        data class SetError(val error: ResultWrapper.Failed) : Message
    }
}