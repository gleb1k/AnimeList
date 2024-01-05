package ru.glebik.feature.auth.internal.presentation.signin.viewmodel

import com.arkivanov.mvikotlin.core.store.Store

interface SignInStore : Store<SignInStore.Intent, SignInStore.State, SignInStore.Label> {

    data class State internal constructor(
        val queryEmail: String = "",
        val queryPassword: String = "",

        val isLoading: Boolean = false,
        val isError: Boolean = false,
    )

    sealed interface Intent {
        data object SignIn : Intent
        data object NavigateToProfile : Intent

        data class OnQueryEmailChange(val query: String) : Intent
        data class OnQueryPasswordChange(val query: String) : Intent
    }

    sealed interface Label {
        data object NavigateToProfile : Label
    }
}


