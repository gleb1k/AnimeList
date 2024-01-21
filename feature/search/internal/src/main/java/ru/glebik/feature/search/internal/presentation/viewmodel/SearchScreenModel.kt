package ru.glebik.feature.search.internal.presentation.viewmodel

import ru.glebik.core.presentation.MviScreenModel


class SearchScreenModel(
    private val store: SearchStore,
) : MviScreenModel<SearchStore.Intent, SearchStore.State, SearchStore.Label>(
    store
) {

    fun navigateToDetails(id: Int) = store.accept(SearchStore.Intent.NavigateToDetails(id))

    fun onQuerySearchChange(query: String) =
        store.accept(SearchStore.Intent.OnQuerySearchChange(query))

    fun onSearchClick(query: String) {
        store.accept(SearchStore.Intent.Search(query = query))
    }
}
