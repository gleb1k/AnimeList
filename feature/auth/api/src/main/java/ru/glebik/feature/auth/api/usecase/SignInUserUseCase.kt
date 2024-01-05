package ru.glebik.feature.auth.api.usecase

import ru.glebik.core.utils.ResultWrapper

interface SignInUserUseCase {
    suspend operator fun invoke(email: String, password: String): ResultWrapper<Boolean>
}