package ru.glebik.feature.search.internal.presentation.viewmodel

import com.arkivanov.mvikotlin.core.store.Store
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import ru.glebik.feature.anime.api.model.domain.AnimeBaseModel

interface SearchStore : Store<SearchStore.Intent, SearchStore.State, SearchStore.Label> {

    data class State internal constructor(
        // Content state
        val searchList: PersistentList<AnimeBaseModel> = persistentListOf(),
        val querySearch: String = "",

        val isLoading: Boolean = false,
        val isError: Boolean = false,
    )

    sealed interface Intent {
        data class Search(val query: String) : Intent
        data class NavigateToDetails(val id: Int) : Intent

        data class OnQuerySearchChange(val query: String) : Intent
    }

    sealed interface Label {
        data class NavigateToDetails(val id: Int) : Label
    }
}


