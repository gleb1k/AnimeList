package ru.glebik.feature.auth.internal.presentation.signup.viewmodel

import com.arkivanov.mvikotlin.core.store.Store

interface SignUpStore : Store<SignUpStore.Intent, SignUpStore.State, SignUpStore.Label> {

    data class State internal constructor(
        val queryNickname: String = "",
        val queryEmail: String = "",
        val queryPassword: String = "",

        val isLoading: Boolean = false,
        val isError: Boolean = false,
    )

    sealed interface Intent {
        data object SignUp : Intent
        data object NavigateToSignIn : Intent

        data class OnQueryNicknameChange(val query: String) : Intent
        data class OnQueryEmailChange(val query: String) : Intent
        data class OnQueryPasswordChange(val query: String) : Intent
    }

    sealed interface Label {
        data object NavigateToSignIn : Label
    }
}


