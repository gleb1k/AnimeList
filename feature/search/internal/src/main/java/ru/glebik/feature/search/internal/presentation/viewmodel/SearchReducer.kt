package ru.glebik.feature.search.internal.presentation.viewmodel

import com.arkivanov.mvikotlin.core.store.Reducer

internal class SearchReducer : Reducer<SearchStore.State, SearchStoreFactory.Message> {

    override fun SearchStore.State.reduce(
        msg: SearchStoreFactory.Message,
    ) = when (msg) {
        is SearchStoreFactory.Message.SetError -> copy(
            isError = true,
            isLoading = false,
        )

        is SearchStoreFactory.Message.SetLoading -> copy(
            isLoading = true,
            isError = false,
        )

        is SearchStoreFactory.Message.SetData -> copy(
            isLoading = false,
            searchList = msg.searchList
        )

        is SearchStoreFactory.Message.SetQuerySearch -> copy(
            querySearch = msg.query
        )
    }
}