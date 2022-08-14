package ru.meseen.rfidreader.data.db.dao

import androidx.room.*

/**
 * @author Vyacheslav Doroshenko
 */
interface BaseDao<Entity> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: Entity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg entity: Entity)

    @Delete
    fun delete(entity: Entity)

    @Update
    fun update(entity: Entity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(listT: List<Entity>)

}