package ru.glebik.feature.profile.internal.presentation.viewmodel

import android.service.autofill.UserData
import com.arkivanov.mvikotlin.core.store.Store

//должен быть в апи
interface ProfileStore : Store<ProfileStore.Intent, ProfileStore.State, ProfileStore.Label> {

    //домейн стейт
    data class State internal constructor(
        val userData: UserData? = null,
        val isLoading: Boolean = false,
        val isError: Boolean = false,
    )

    sealed interface Intent {
        data object LoadUserData : Intent
    }

    sealed interface Label
}


