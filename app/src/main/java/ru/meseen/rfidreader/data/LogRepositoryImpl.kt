package ru.meseen.rfidreader.data

import androidx.paging.PagingSource
import ru.meseen.rfidreader.data.db.dao.LogDao
import ru.meseen.rfidreader.data.db.entity.LogEntity
import ru.meseen.rfidreader.data.mappers.toEntity
import ru.meseen.rfidreader.data.model.LogModel
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Vyacheslav Doroshenko
 */
@Singleton
class LogRepositoryImpl @Inject constructor(private val logDao: LogDao) : LogRepository {

    override fun loadLogs(): PagingSource<Int, LogEntity> = logDao.getLog()

    override suspend fun clearLogs() {
        logDao.dropTable()
    }


    override suspend fun insert(vararg logModel: LogModel) {
        logModel.onEach { model -> logDao.insert(model.toEntity()) }
    }


}