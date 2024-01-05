package ru.glebik.feature.auth.api.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.glebik.feature.auth.api.model.UserEntity

@Dao
interface UserDao {
    //unsafe
    //todo token
    @Query("SELECT * FROM users WHERE email=:email AND password=:password")
    suspend fun byEmailPassword(email: String, password: String): UserEntity?

    @Query("SELECT * FROM users WHERE email=:email")
    suspend fun byEmail(email: String): UserEntity?

    @Query("SELECT * FROM users WHERE name=:name")
    suspend fun byName(name: String): UserEntity?

    @Query("SELECT * FROM users WHERE name=:id")
    suspend fun byId(id: Int): UserEntity?


    @Insert
    suspend fun insert(entity: UserEntity)

}