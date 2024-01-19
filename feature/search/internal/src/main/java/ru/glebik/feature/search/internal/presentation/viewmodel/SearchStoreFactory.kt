package ru.glebik.feature.search.internal.presentation.viewmodel

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import kotlinx.collections.immutable.PersistentList
import kotlinx.coroutines.CoroutineDispatcher
import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.anime.api.model.domain.AnimeBaseModel
import ru.glebik.feature.anime.api.usecase.SearchAnimeUseCase

internal class SearchStoreFactory(
    private val storeFactory: StoreFactory,
    private val searchAnimeUseCase: SearchAnimeUseCase,
    private val ioDispatcher: CoroutineDispatcher
) {
    fun create(): SearchStore = object :
        SearchStore,
        Store<SearchStore.Intent, SearchStore.State, SearchStore.Label> by storeFactory.create(
            name = SearchStore::class.simpleName,
            initialState = SearchStore.State(),
            bootstrapper = null,
            executorFactory = {
                SearchExecutor(
                    searchAnimeUseCase,
                    ioDispatcher
                )
            },
            reducer = SearchReducer(),
        ) {}

    sealed interface Message {
        data object SetLoading : Message
        data class SetData(
            val searchList: PersistentList<AnimeBaseModel>
        ) : Message

        data class SetQuerySearch(val query: String) : Message
        data class SetError(val error: ResultWrapper.Failed) : Message
    }
}