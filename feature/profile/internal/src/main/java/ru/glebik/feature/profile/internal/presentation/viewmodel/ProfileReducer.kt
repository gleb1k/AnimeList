package ru.glebik.feature.profile.internal.presentation.viewmodel

import com.arkivanov.mvikotlin.core.store.Reducer

internal class ProfileReducer : Reducer<ProfileStore.State, ProfileStoreFactory.Message> {

    override fun ProfileStore.State.reduce(
        msg: ProfileStoreFactory.Message,
    ) = when (msg) {
        is ProfileStoreFactory.Message.SetError -> copy(
            isError = true,
            isLoading = false,
        )

        is ProfileStoreFactory.Message.SetLoading -> copy(
            isLoading = true,
            isError = false,
        )

        is ProfileStoreFactory.Message.SetUser -> copy(
            isLoading = false,
            userData = msg.userData,
        )
    }
}