package ru.glebik.feature.auth.api.usecase

import ru.glebik.core.utils.ResultWrapper

interface IsUserAuthorizedUseCase {
    suspend operator fun invoke(): ResultWrapper<Boolean>
}