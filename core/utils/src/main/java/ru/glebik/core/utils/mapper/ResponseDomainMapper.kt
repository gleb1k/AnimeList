package ru.glebik.core.utils.mapper

interface ResponseDomainMapper<Response, Domain> {
    fun toDomain(response: Response): Domain
}
