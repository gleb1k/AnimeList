package ru.glebik.feature.profile.internal.presentation.viewmodel

import kotlinx.coroutines.CoroutineDispatcher
import ru.glebik.core.presentation.BaseExecutor
import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.auth.api.UserToken
import ru.glebik.feature.auth.api.usecase.GetUserDataUseCase
import ru.glebik.feature.auth.api.usecase.IsUserAuthorizedUseCase

internal class ProfileExecutor(
    private val getUserDataUserUseCase: GetUserDataUseCase,
    private val isUserAuthorizedUseCase: IsUserAuthorizedUseCase,
    private val ioDispatcher: CoroutineDispatcher,
) : BaseExecutor<ProfileStore.Intent, Nothing, ProfileStore.State, ProfileStoreFactory.Message, ProfileStore.Label>() {

    override suspend fun suspendExecuteIntent(
        intent: ProfileStore.Intent,
        getState: () -> ProfileStore.State,
    ) = when (intent) {
        is ProfileStore.Intent.LoadUserData -> with(ioDispatcher) {
            loadUserData()
        }

        ProfileStore.Intent.CheckIsAuthorized -> with(ioDispatcher) {
            checkIsUserAuthorized()
        }
    }

    private suspend fun loadUserData() {
        dispatch(ProfileStoreFactory.Message.SetLoading)
        when (val response = getUserDataUserUseCase(UserToken.id ?: -1)) {
            is ResultWrapper.Success -> {
                dispatch(
                    ProfileStoreFactory.Message.SetUser(response.data)
                )
            }

            is ResultWrapper.Failed -> dispatch(
                ProfileStoreFactory.Message.SetError(
                    ResultWrapper.Failed(
                        response.exception,
                        response.errorMessage
                    )
                )
            )
        }
    }

    private suspend fun checkIsUserAuthorized() {
        dispatch(ProfileStoreFactory.Message.SetLoading)
        when (val response = isUserAuthorizedUseCase()) {
            is ResultWrapper.Success -> {
                dispatch(
                    ProfileStoreFactory.Message.SetIsAuth(response.data)
                )
            }

            is ResultWrapper.Failed -> dispatch(
                ProfileStoreFactory.Message.SetError(
                    ResultWrapper.Failed(
                        response.exception,
                        response.errorMessage
                    )
                )
            )
        }
    }

}
