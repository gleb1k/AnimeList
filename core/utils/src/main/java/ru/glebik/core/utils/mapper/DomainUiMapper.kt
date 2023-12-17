package ru.glebik.core.utils.mapper

interface DomainUiMapper<Domain, Ui> {
    fun toDomain(ui: Ui): Domain
    fun toUi(domain: Domain): Ui
}