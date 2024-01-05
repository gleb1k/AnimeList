package ru.glebik.feature.auth.internal.presentation.signup.viewmodel

import com.arkivanov.mvikotlin.core.store.Reducer

internal class SignUpReducer : Reducer<SignUpStore.State, SignUpStoreFactory.Message> {

    override fun SignUpStore.State.reduce(
        msg: SignUpStoreFactory.Message,
    ) = when (msg) {
        is SignUpStoreFactory.Message.SetError -> copy(
            isError = true,
            isLoading = false,
        )

        is SignUpStoreFactory.Message.SetLoading -> copy(
            isLoading = true,
            isError = false,
        )

        is SignUpStoreFactory.Message.SetQueryEmail -> copy(
            queryEmail = msg.query
        )

        is SignUpStoreFactory.Message.SetQueryNickname -> copy(
            queryNickname = msg.query
        )

        is SignUpStoreFactory.Message.SetQueryPassword -> copy(
            queryPassword = msg.query
        )
    }
}