package ru.meseen.rfidreader.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.meseen.rfidreader.BuildConfig
import ru.meseen.rfidreader.data.db.dao.LogDao
import ru.meseen.rfidreader.data.db.entity.LogEntity
import ru.meseen.rfidreader.data.db.typeconverter.DateTypeConverter

/**
 * @author Vyacheslav Doroshenko
 */
@Database(
    exportSchema = false,
    version = BuildConfig.DB_VERSION,
    entities = [LogEntity::class]

)
@TypeConverters(value = [DateTypeConverter::class])
abstract class MainDB : RoomDatabase() {

    abstract val logDao: LogDao
}