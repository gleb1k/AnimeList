package ru.glebik.core.utils.mapper

interface EntityDomainMapper<Entity, Domain> {
    fun toEntity(domain: Domain): Entity
    fun toDomain(entity: Entity): Domain
}