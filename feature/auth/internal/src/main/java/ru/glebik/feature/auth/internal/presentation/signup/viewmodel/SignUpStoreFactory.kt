package ru.glebik.feature.auth.internal.presentation.signup.viewmodel

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.auth.api.usecase.SignUpUserUseCase

internal class SignUpStoreFactory(
    private val storeFactory: StoreFactory,
    private val signUpUserUseCase: SignUpUserUseCase
) {
    fun create(): SignUpStore = object :
        SignUpStore,
        Store<SignUpStore.Intent, SignUpStore.State, SignUpStore.Label> by storeFactory.create(
            name = SignUpStore::class.simpleName,
            initialState = SignUpStore.State(),
            bootstrapper = null,
            executorFactory = {
                SignUpExecutor(
                    signUpUserUseCase
                )
            },
            reducer = SignUpReducer(),
        ) {}

    sealed interface Message {
        data object SetLoading : Message
        data class SetError(val error: ResultWrapper.Failed) : Message

        data class SetQueryNickname(val query: String) : Message
        data class SetQueryEmail(val query: String) : Message
        data class SetQueryPassword(val query: String) : Message
    }
}