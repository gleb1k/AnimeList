package ru.glebik.feature.auth.internal.presentation.signin.viewmodel

import ru.glebik.core.presentation.MviScreenModel


class SignInScreenModel(
    private val store: SignInStore,
) : MviScreenModel<SignInStore.Intent, SignInStore.State, SignInStore.Label>(
    store
) {

    fun onQueryEmailChange(query: String) =
        store.accept(SignInStore.Intent.OnQueryEmailChange(query))

    fun onQueryPasswordChange(query: String) =
        store.accept(SignInStore.Intent.OnQueryPasswordChange(query))

    fun onSignInClick() = store.accept(SignInStore.Intent.SignIn)

}


