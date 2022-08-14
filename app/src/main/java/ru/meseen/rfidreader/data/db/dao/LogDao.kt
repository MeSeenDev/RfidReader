package ru.meseen.rfidreader.data.db.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import ru.meseen.rfidreader.data.db.entity.LogEntity

/**
 * @author Vyacheslav Doroshenko
 */
@Dao
interface LogDao :BaseDao<LogEntity>{

    @Query("SELECT * FROM ${LogEntity.TABLE_NAME}")
    fun getLog(): PagingSource<Int, LogEntity>

    @Query("DELETE FROM ${LogEntity.TABLE_NAME}")
    fun dropTable()
}