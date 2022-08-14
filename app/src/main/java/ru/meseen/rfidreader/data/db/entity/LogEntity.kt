package ru.meseen.rfidreader.data.db.entity

import android.provider.BaseColumns
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.meseen.rfidreader.data.db.entity.LogEntity.Companion.TABLE_NAME
import java.util.Date

/**
 * @author Vyacheslav Doroshenko
 */
@Entity(
    tableName = TABLE_NAME
)
data class LogEntity(
    @PrimaryKey
    @ColumnInfo(name = BaseColumns._ID)
    val _id: Long? = null,
    @ColumnInfo(name = "message", defaultValue = "n-a-n")
    val message: String="",
    @ColumnInfo(name = "messageDate")
    val date: Date = Date(0)
){
    companion object{
        const val TABLE_NAME = "LogTable"
    }
}