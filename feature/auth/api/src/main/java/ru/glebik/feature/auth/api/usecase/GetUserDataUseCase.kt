package ru.glebik.feature.auth.api.usecase

import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.auth.api.model.UserData

interface GetUserDataUseCase {
    suspend operator fun invoke(token: Int): ResultWrapper<UserData>
}