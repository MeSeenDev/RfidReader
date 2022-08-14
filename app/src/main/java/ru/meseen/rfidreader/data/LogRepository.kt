package ru.meseen.rfidreader.data

import androidx.paging.PagingSource
import ru.meseen.rfidreader.data.db.entity.LogEntity
import ru.meseen.rfidreader.data.model.LogModel

interface LogRepository {


    fun loadLogs(): PagingSource<Int, LogEntity>

    suspend fun clearLogs()

    suspend fun insert(vararg logModel: LogModel)



}
