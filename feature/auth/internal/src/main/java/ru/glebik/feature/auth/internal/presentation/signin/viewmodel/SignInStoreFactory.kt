package ru.glebik.feature.auth.internal.presentation.signin.viewmodel

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.auth.api.usecase.SignInUserUseCase

internal class SignInStoreFactory(
    private val storeFactory: StoreFactory,
    private val signInUserUseCase: SignInUserUseCase
) {
    fun create(): SignInStore = object :
        SignInStore,
        Store<SignInStore.Intent, SignInStore.State, SignInStore.Label> by storeFactory.create(
            name = SignInStore::class.simpleName,
            initialState = SignInStore.State(),
            bootstrapper = null,
            executorFactory = {
                SignInExecutor(
                    signInUserUseCase
                )
            },
            reducer = SignInReducer(),
        ) {}

    sealed interface Message {
        data object SetLoading : Message
        data class SetError(val error: ResultWrapper.Failed) : Message

        data class SetQueryEmail(val query: String) : Message
        data class SetQueryPassword(val query: String) : Message
    }
}