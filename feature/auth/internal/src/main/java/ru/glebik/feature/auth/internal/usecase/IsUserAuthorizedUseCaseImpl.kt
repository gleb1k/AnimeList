package ru.glebik.feature.auth.internal.usecase

import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.auth.api.repository.AuthRepository
import ru.glebik.feature.auth.api.usecase.IsUserAuthorizedUseCase

class IsUserAuthorizedUseCaseImpl(
    private val repository: AuthRepository
) : IsUserAuthorizedUseCase {
    override suspend fun invoke(): ResultWrapper<Boolean> = repository.isUserAuthorized()
}