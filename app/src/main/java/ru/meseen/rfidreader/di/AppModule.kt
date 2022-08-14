package ru.meseen.rfidreader.di

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.meseen.rfidreader.BuildConfig
import ru.meseen.rfidreader.data.LogRepository
import ru.meseen.rfidreader.data.LogRepositoryImpl
import ru.meseen.rfidreader.data.db.MainDB
import ru.meseen.rfidreader.data.db.dao.LogDao
import javax.inject.Singleton

/**
 * @author Vyacheslav Doroshenko
 */
@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideDb(@ApplicationContext appContext: Context): MainDB =
        Room.databaseBuilder(
            appContext,
            MainDB::class.java,
            BuildConfig.DB_FILE_NAME
        ).fallbackToDestructiveMigration()
            .build()


    @Provides
    @Singleton
    fun provideLogDao(db: MainDB): LogDao = db.logDao


    @Provides
    @Singleton
    fun provideLogRepo(logRepositoryImpl: LogRepositoryImpl): LogRepository = logRepositoryImpl

}