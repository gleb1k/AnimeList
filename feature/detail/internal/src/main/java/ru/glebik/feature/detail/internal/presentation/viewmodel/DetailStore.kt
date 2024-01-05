package ru.glebik.feature.detail.internal.presentation.viewmodel

import com.arkivanov.mvikotlin.core.store.Store
import ru.glebik.feature.anime.api.model.domain.AnimeFull

interface DetailStore : Store<DetailStore.Intent, DetailStore.State, DetailStore.Label> {

    data class State internal constructor(
        val anime: AnimeFull? = null,

        val isLoading: Boolean = false,
        val isError: Boolean = false,
    )

    sealed interface Intent {
        data class Load(val id: Int) : Intent
        data class NavigateTo(val id: Int) : Intent
    }

    sealed interface Label {
        data class NavigateTo(val id: Int) : Label
    }
}


