package ru.meseen.rfidreader.data.mappers

import ru.meseen.rfidreader.data.db.entity.LogEntity
import ru.meseen.rfidreader.data.model.LogModel

/**
 * @author Vyacheslav Doroshenko
 */

fun LogEntity.toModel(): LogModel =
    LogModel(message, date)

fun LogModel.toEntity(): LogEntity =
    LogEntity(null,message, date)