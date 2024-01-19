package ru.glebik.feature.home.internal.presentation.viewmodel

import com.arkivanov.mvikotlin.core.store.Store
import ru.glebik.feature.anime.api.model.domain.AnimeBaseModel
import ru.glebik.feature.anime.api.model.domain.AnimeRecommendation

//должен быть в апи
interface HomeStore : Store<HomeStore.Intent, HomeStore.State, HomeStore.Label> {

    //домейн стейт
    data class State internal constructor(
        val recommendations: List<AnimeRecommendation> = listOf(),
        val seasonNow: List<AnimeBaseModel> = listOf(),
        val topByScore: List<AnimeBaseModel> = listOf(),
        val isLoading: Boolean = false,
        val isError: Boolean = false,
    )

    sealed interface Intent {
        data object LoadRecommendations : Intent
        data object LoadSeasonNow : Intent
        data object LoadTopByScore : Intent
        data class NavigateToDetails(val id: Int) : Intent
    }

    sealed interface Label {
        data class NavigateToDetails(val id: Int) : Label
    }
}


