package ru.glebik.feature.auth.internal.usecase

import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.auth.api.repository.AuthRepository
import ru.glebik.feature.auth.api.usecase.SignUpUserUseCase

class SignUpUserUseCaseImpl(
    private val repository: AuthRepository
) : SignUpUserUseCase {
    override suspend fun invoke(
        name: String,
        email: String,
        password: String
    ): ResultWrapper<Boolean> = repository.signUp(name, email, password)
}