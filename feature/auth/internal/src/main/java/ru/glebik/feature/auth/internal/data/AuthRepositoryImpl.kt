package ru.glebik.feature.auth.internal.data

import android.util.Log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.glebik.core.db.MainDatabase
import ru.glebik.core.utils.ResultWrapper
import ru.glebik.core.utils.mapper.DaoMapper
import ru.glebik.feature.auth.api.UserToken
import ru.glebik.feature.auth.api.model.UserData
import ru.glebik.feature.auth.api.model.UserEntity
import ru.glebik.feature.auth.api.repository.AuthRepository

class AuthRepositoryImpl(
    db: MainDatabase,
    private val userDaoMapper: DaoMapper<UserEntity, UserData>,
    private val ioDispatcher: CoroutineDispatcher
) : AuthRepository {

    private val userDao = db.userDao()

    override suspend fun signUp(
        name: String,
        email: String,
        password: String
    ): ResultWrapper<Boolean> = withContext(ioDispatcher) {
        //todo жижа
        if (userDao.byEmail(email) != null || userDao.byName(name) != null) {
            Log.e("AuthRepositoryImpl.SignUp", "User already registered!")
            return@withContext ResultWrapper.Failed(null, "User already registered!", -1)
        }
        runCatching {
            userDao.insert(userDaoMapper.toEntity(UserData(name, password, email)))

        }.fold(
            onSuccess = {
                Log.i("AuthRepositoryImpl.SignUp", "User was inserted")
                ResultWrapper.Success(data = true)

            },
            onFailure = {
                Log.i("AuthRepositoryImpl.SignUp", "User was NOT inserted")
                ResultWrapper.Failed(it, it.message)
            }
        )
    }

    override suspend fun signIn(email: String, password: String): ResultWrapper<Boolean> =
        withContext(ioDispatcher) {
            runCatching {
                userDao.byEmailPassword(email, password)
            }.fold(
                onSuccess = {
                    if (it == null)
                        return@fold ResultWrapper.Failed(null, "User is not registered!", -1)
                    else {
                        UserToken.id = it.id
                        return@fold ResultWrapper.Success(data = true)
                    }
                },
                onFailure = {
                    ResultWrapper.Failed(it, it.message)
                }
            )
        }

    override suspend fun getUserById(id: Int): ResultWrapper<UserData> =
        withContext(ioDispatcher) {
            runCatching {
                userDao.byId(id)
            }.fold(
                onSuccess = {
                    if (it == null)
                        return@fold ResultWrapper.Failed(null, "User doesn't exist", -1)
                    else {
                        return@fold ResultWrapper.Success(data = userDaoMapper.toDomain(it))
                    }
                },
                onFailure = {
                    ResultWrapper.Failed(it, it.message)
                }
            )
        }

    override suspend fun isUserAuthorized(): ResultWrapper<Boolean> = if (UserToken.id != null)
        ResultWrapper.Success(true) else ResultWrapper.Success(false)

}
