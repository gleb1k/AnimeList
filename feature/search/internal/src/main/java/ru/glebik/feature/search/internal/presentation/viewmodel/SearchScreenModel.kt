package ru.glebik.feature.search.internal.presentation.viewmodel

import ru.glebik.core.presentation.MviScreenModel


class SearchScreenModel(
    private val store: SearchStore,
) : MviScreenModel<SearchStore.Intent, SearchStore.State, SearchStore.Label>(
    store
) {

    fun navigate(id: Int) = store.accept(SearchStore.Intent.NavigateToDetails(id))

    fun load(query: String) = store.accept(SearchStore.Intent.Search(query))

}
