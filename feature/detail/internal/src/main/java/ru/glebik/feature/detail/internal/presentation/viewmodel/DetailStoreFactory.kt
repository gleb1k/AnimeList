package ru.glebik.feature.detail.internal.presentation.viewmodel

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.anime.api.model.domain.AnimeFull
import ru.glebik.feature.anime.api.usecase.GetAnimeFullUseCase

internal class DetailStoreFactory(
    private val storeFactory: StoreFactory,
    private val getAnimeFullUseCase: GetAnimeFullUseCase,
) {
    fun create(): DetailStore = object :
        DetailStore,
        Store<DetailStore.Intent, DetailStore.State, DetailStore.Label> by storeFactory.create(
            name = DetailStore::class.simpleName,
            initialState = DetailStore.State(),
            bootstrapper = null,
            executorFactory = {
                DetailExecutor(
                    getAnimeFullUseCase
                )
            },
            reducer = DetailReducer(),
        ) {}

    sealed interface Message {
        data object SetLoading : Message
        data class SetAnime(
            val anime: AnimeFull
        ) : Message

        data class SetError(val error: ResultWrapper.Failed) : Message
    }
}