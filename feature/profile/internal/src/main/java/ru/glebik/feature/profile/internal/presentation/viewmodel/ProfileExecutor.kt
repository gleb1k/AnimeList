package ru.glebik.feature.profile.internal.presentation.viewmodel

import kotlinx.coroutines.Dispatchers
import ru.glebik.core.presentation.BaseExecutor

internal class ProfileExecutor : BaseExecutor<ProfileStore.Intent, Nothing, ProfileStore.State, ProfileStoreFactory.Message, ProfileStore.Label>() {

    override suspend fun suspendExecuteIntent(
        intent: ProfileStore.Intent,
        getState: () -> ProfileStore.State,
    ) = when (intent) {
        is ProfileStore.Intent.LoadUserData -> with(Dispatchers.IO) {
            loadUserData()
        }
    }

    private suspend fun loadUserData() {
        dispatch(ProfileStoreFactory.Message.SetLoading)

    }

}
