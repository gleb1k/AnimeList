package ru.glebik.feature.auth.api.usecase

interface SignUpUserUseCase {
    suspend operator fun invoke(name: String, email: String, password: String)
}