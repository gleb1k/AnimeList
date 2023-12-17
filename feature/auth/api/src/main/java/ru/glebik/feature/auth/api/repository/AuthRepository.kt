package ru.glebik.feature.auth.api.repository

interface AuthRepository {

    suspend fun signUp(name: String, email: String, password: String)

    suspend fun signIn(email: String, password: String)

}