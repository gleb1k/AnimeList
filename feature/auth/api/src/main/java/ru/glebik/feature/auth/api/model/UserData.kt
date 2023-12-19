package ru.glebik.feature.auth.api.model

data class UserData(
    val name: String,
    val password: String,
    val email: String,
)