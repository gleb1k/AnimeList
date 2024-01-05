package ru.glebik.feature.auth.internal.presentation.signin.viewmodel

import com.arkivanov.mvikotlin.core.store.Reducer

internal class SignInReducer : Reducer<SignInStore.State, SignInStoreFactory.Message> {

    override fun SignInStore.State.reduce(
        msg: SignInStoreFactory.Message,
    ) = when (msg) {
        is SignInStoreFactory.Message.SetError -> copy(
            isError = true,
            isLoading = false,
        )

        is SignInStoreFactory.Message.SetLoading -> copy(
            isLoading = true,
            isError = false,
        )

        is SignInStoreFactory.Message.SetQueryEmail -> copy(
            queryEmail = msg.query
        )

        is SignInStoreFactory.Message.SetQueryPassword -> copy(
            queryPassword = msg.query
        )
    }
}