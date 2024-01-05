package ru.glebik.feature.auth.internal.usecase

import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.auth.api.repository.AuthRepository
import ru.glebik.feature.auth.api.usecase.SignInUserUseCase

class SignInUserUseCaseImpl(
    private val repository: AuthRepository
) : SignInUserUseCase {
    override suspend fun invoke(email: String, password: String): ResultWrapper<Boolean> =
        repository.signIn(email, password)
}