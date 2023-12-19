package ru.glebik.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.glebik.core.db.converter.DateConverter
import ru.glebik.feature.auth.api.dao.UserDao
import ru.glebik.feature.auth.api.model.UserEntity

@Database(
    version = DatabaseConstants.VERSION,
    entities = [
        UserEntity::class,
    ],
    autoMigrations = [

    ]
)
@TypeConverters(
    DateConverter::class
)
abstract class MainDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
