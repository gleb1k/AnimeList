package ru.glebik.feature.auth.internal.presentation.signup.viewmodel

import kotlinx.coroutines.Dispatchers
import ru.glebik.core.presentation.BaseExecutor
import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.auth.api.usecase.SignUpUserUseCase

internal class SignUpExecutor(
    // UseCase's
    private val signUpUserUseCase: SignUpUserUseCase
) : BaseExecutor<SignUpStore.Intent, Nothing, SignUpStore.State, SignUpStoreFactory.Message, SignUpStore.Label>() {

    override suspend fun suspendExecuteIntent(
        intent: SignUpStore.Intent,
        getState: () -> SignUpStore.State,
    ) = when (intent) {
        is SignUpStore.Intent.SignUp -> with(Dispatchers.IO) {
            signUp(getState())
        }

        is SignUpStore.Intent.OnQueryEmailChange -> dispatch(
            SignUpStoreFactory.Message.SetQueryEmail(
                intent.query
            )
        )

        is SignUpStore.Intent.OnQueryPasswordChange -> dispatch(
            SignUpStoreFactory.Message.SetQueryPassword(
                intent.query
            )
        )

        is SignUpStore.Intent.OnQueryNicknameChange -> dispatch(
            SignUpStoreFactory.Message.SetQueryNickname(
                intent.query
            )
        )

        SignUpStore.Intent.NavigateToSignIn -> {}
    }

    private suspend fun signUp(state: SignUpStore.State) {
        dispatch(SignUpStoreFactory.Message.SetLoading)
        when (val response =
            signUpUserUseCase(state.queryNickname, state.queryEmail, state.queryPassword)) {
            is ResultWrapper.Success -> {
                publish(SignUpStore.Label.NavigateToSignIn)
            }

            is ResultWrapper.Failed -> dispatch(
                SignUpStoreFactory.Message.SetError(
                    ResultWrapper.Failed(
                        response.exception,
                        response.errorMessage
                    )
                )
            )
        }
    }
}

