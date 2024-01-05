package ru.glebik.feature.auth.api.usecase

import ru.glebik.core.utils.ResultWrapper

interface SignUpUserUseCase {
    suspend operator fun invoke(
        name: String,
        email: String,
        password: String
    ): ResultWrapper<Boolean>
}