package ru.glebik.feature.auth.api.usecase

interface SignInUserUseCase {
    suspend operator fun invoke(email: String, password: String)
}