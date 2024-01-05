package ru.glebik.feature.auth.api.repository

import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.auth.api.model.UserData

interface AuthRepository {

    suspend fun signUp(name: String, email: String, password: String): ResultWrapper<Boolean>

    suspend fun signIn(email: String, password: String): ResultWrapper<Boolean>

    suspend fun getUserById(id: Int): ResultWrapper<UserData>

    suspend fun isUserAuthorized(): ResultWrapper<Boolean>

}