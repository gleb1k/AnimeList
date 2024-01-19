package ru.glebik.feature.search.internal.presentation.viewmodel

import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.CoroutineDispatcher
import ru.glebik.core.presentation.BaseExecutor
import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.anime.api.usecase.SearchAnimeUseCase

internal class SearchExecutor(
    private val searchAnimeUseCase: SearchAnimeUseCase,
    private val ioDispatcher: CoroutineDispatcher,
) : BaseExecutor<SearchStore.Intent, Nothing, SearchStore.State, SearchStoreFactory.Message, SearchStore.Label>() {

    override suspend fun suspendExecuteIntent(
        intent: SearchStore.Intent,
        getState: () -> SearchStore.State,
    ) = when (intent) {
        is SearchStore.Intent.Search -> search(intent.query)

        is SearchStore.Intent.NavigateToDetails -> publish(SearchStore.Label.NavigateToDetails(id = intent.id))
        is SearchStore.Intent.OnQuerySearchChange -> dispatch(
            SearchStoreFactory.Message.SetQuerySearch(
                intent.query
            )
        )
    }

    private suspend fun search(query: String) {
        dispatch(SearchStoreFactory.Message.SetLoading)
        when (val response = with(ioDispatcher) { searchAnimeUseCase(query) }) {
            is ResultWrapper.Success -> {
                dispatch(
                    SearchStoreFactory.Message.SetData(response.data.toPersistentList())
                )
            }

            is ResultWrapper.Failed -> dispatch(
                SearchStoreFactory.Message.SetError(
                    ResultWrapper.Failed(
                        response.exception,
                        response.errorMessage
                    )
                )
            )
        }
    }

}
