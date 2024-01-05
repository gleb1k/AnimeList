package ru.glebik.feature.detail.internal.presentation.viewmodel

import kotlinx.coroutines.Dispatchers
import ru.glebik.core.presentation.BaseExecutor
import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.anime.api.usecase.GetAnimeFullUseCase

internal class DetailExecutor(
    // UseCase's
    private val getAnimeFullUseCase: GetAnimeFullUseCase,
) : BaseExecutor<DetailStore.Intent, Nothing, DetailStore.State, DetailStoreFactory.Message, DetailStore.Label>() {

    override suspend fun suspendExecuteIntent(
        intent: DetailStore.Intent,
        getState: () -> DetailStore.State,
    ) = when (intent) {
        is DetailStore.Intent.Load -> with(Dispatchers.IO) {
            loadAnimeRecommendation(intent.id)
        }

        is DetailStore.Intent.NavigateTo -> publish(DetailStore.Label.NavigateTo(id = intent.id))
    }

    private suspend fun loadAnimeRecommendation(id: Int) {
        dispatch(DetailStoreFactory.Message.SetLoading)
        when (val response = getAnimeFullUseCase(id)) {
            is ResultWrapper.Success -> {
                dispatch(
                    DetailStoreFactory.Message.SetAnime(response.data)
                )
            }

            is ResultWrapper.Failed -> dispatch(
                DetailStoreFactory.Message.SetError(
                    ResultWrapper.Failed(
                        response.exception,
                        response.errorMessage
                    )
                )
            )
        }
    }

}
