package ru.glebik.feature.auth.internal.usecase

import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.auth.api.model.UserData
import ru.glebik.feature.auth.api.repository.AuthRepository
import ru.glebik.feature.auth.api.usecase.GetUserDataUseCase

class GetUserDataUseCaseImpl(
    private val repository: AuthRepository
) : GetUserDataUseCase {
    override suspend fun invoke(token: Int): ResultWrapper<UserData> = repository.getUserById(token)
}