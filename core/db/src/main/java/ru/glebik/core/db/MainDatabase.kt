package ru.glebik.core.db

import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.glebik.core.db.converter.DateConverter

@Database(
    version = DatabaseConstants.VERSION,
    entities = [
        tempEntity::class
    ],
    autoMigrations = [

    ]
)
@TypeConverters(
    DateConverter::class
)
abstract class MainDatabase : RoomDatabase() {
}

@Entity
data class tempEntity(
    @PrimaryKey
    val id: Int
)