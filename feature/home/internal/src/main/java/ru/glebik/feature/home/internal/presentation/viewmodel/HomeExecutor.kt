package ru.glebik.feature.home.internal.presentation.viewmodel

import kotlinx.coroutines.Dispatchers
import ru.glebik.core.presentation.BaseExecutor
import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.anime.api.AnimeConstants
import ru.glebik.feature.anime.api.usecase.GetAnimeRecommendationsUseCase

internal class HomeExecutor(
    private val getAnimeRecommendationsUseCase: GetAnimeRecommendationsUseCase,
) : BaseExecutor<HomeStore.Intent, Nothing, HomeStore.State, HomeStoreFactory.Message, HomeStore.Label>() {

    override suspend fun suspendExecuteIntent(
        intent: HomeStore.Intent,
        getState: () -> HomeStore.State,
    ) = when (intent) {
        is HomeStore.Intent.LoadRecommendations -> with(Dispatchers.IO) {
            loadAnimeRecommendation()
        }

        is HomeStore.Intent.NavigateToDetails -> publish(HomeStore.Label.NavigateToDetails(id = intent.id))
    }

    private suspend fun loadAnimeRecommendation() {
        dispatch(HomeStoreFactory.Message.SetLoading)
        when (val response = getAnimeRecommendationsUseCase(AnimeConstants.ANIME_ID)) {
            is ResultWrapper.Success -> {
                dispatch(
                    HomeStoreFactory.Message.SetRecommendations(response.data)
                )
            }

            is ResultWrapper.Failed -> dispatch(
                HomeStoreFactory.Message.SetError(
                    ResultWrapper.Failed(
                        response.exception,
                        response.errorMessage
                    )
                )
            )
        }
    }

}
