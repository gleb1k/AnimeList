package ru.glebik.feature.auth.internal.data.mapper

import ru.glebik.core.utils.mapper.DaoMapper
import ru.glebik.feature.auth.api.model.UserData
import ru.glebik.feature.auth.api.model.UserEntity

class UserDaoMapper : DaoMapper<UserEntity, UserData> {
    override fun toEntity(domain: UserData): UserEntity = UserEntity(
        name = domain.name,
        email = domain.email,
        password = domain.password
    )

    override fun toDomain(entity: UserEntity): UserData = UserData(
        name = entity.name,
        email = entity.email,
        password = entity.password
    )

    companion object {
        const val TAG = "UserDaoMapper"
    }
}