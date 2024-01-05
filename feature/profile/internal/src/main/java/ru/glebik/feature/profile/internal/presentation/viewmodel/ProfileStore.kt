package ru.glebik.feature.profile.internal.presentation.viewmodel

import com.arkivanov.mvikotlin.core.store.Store
import ru.glebik.feature.auth.api.model.UserData

interface ProfileStore : Store<ProfileStore.Intent, ProfileStore.State, ProfileStore.Label> {

    data class State internal constructor(
        val isAuth: Boolean = false,
        val userData: UserData? = null,

        val isLoading: Boolean = false,
        val isError: Boolean = false,
    )

    sealed interface Intent {
        data object LoadUserData : Intent
        data object CheckIsAuthorized : Intent
    }

    sealed interface Label
}


