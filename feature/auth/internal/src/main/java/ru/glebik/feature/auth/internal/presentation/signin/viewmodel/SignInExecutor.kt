package ru.glebik.feature.auth.internal.presentation.signin.viewmodel

import kotlinx.coroutines.Dispatchers
import ru.glebik.core.presentation.BaseExecutor
import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.auth.api.usecase.SignInUserUseCase

internal class SignInExecutor(
    // UseCase's
    private val signInUserUseCase: SignInUserUseCase
) : BaseExecutor<SignInStore.Intent, Nothing, SignInStore.State, SignInStoreFactory.Message, SignInStore.Label>() {

    override suspend fun suspendExecuteIntent(
        intent: SignInStore.Intent,
        getState: () -> SignInStore.State,
    ) = when (intent) {
        is SignInStore.Intent.SignIn -> with(Dispatchers.IO) {
            signIn(getState())
        }

        is SignInStore.Intent.OnQueryEmailChange -> dispatch(
            SignInStoreFactory.Message.SetQueryEmail(
                intent.query
            )
        )

        is SignInStore.Intent.OnQueryPasswordChange -> dispatch(
            SignInStoreFactory.Message.SetQueryPassword(
                intent.query
            )
        )

        SignInStore.Intent.NavigateToProfile -> publish(SignInStore.Label.NavigateToProfile)
    }

    private suspend fun signIn(state: SignInStore.State) {
        dispatch(SignInStoreFactory.Message.SetLoading)
        when (val response = signInUserUseCase(state.queryEmail, state.queryPassword)) {
            is ResultWrapper.Success -> {
                publish(SignInStore.Label.NavigateToProfile)
            }

            is ResultWrapper.Failed -> dispatch(
                SignInStoreFactory.Message.SetError(
                    ResultWrapper.Failed(
                        response.exception,
                        response.errorMessage
                    )
                )
            )
        }
    }

}
