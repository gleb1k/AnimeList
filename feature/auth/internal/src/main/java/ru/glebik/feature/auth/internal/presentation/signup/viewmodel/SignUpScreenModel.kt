package ru.glebik.feature.auth.internal.presentation.signup.viewmodel

import ru.glebik.core.presentation.MviScreenModel


class SignUpScreenModel(
    private val store: SignUpStore,
) : MviScreenModel<SignUpStore.Intent, SignUpStore.State, SignUpStore.Label>(
    store
) {

    fun onQueryEmailChange(query: String) =
        store.accept(SignUpStore.Intent.OnQueryEmailChange(query))

    fun onQueryNicknameChange(query: String) =
        store.accept(SignUpStore.Intent.OnQueryNicknameChange(query))

    fun onQueryPasswordChange(query: String) =
        store.accept(SignUpStore.Intent.OnQueryPasswordChange(query))

    fun onSignUpClick() {
        store.accept(SignUpStore.Intent.SignUp)
    }

}
