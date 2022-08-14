package ru.meseen.rfidreader.ui.log

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import ru.meseen.rfidreader.data.LogRepository
import ru.meseen.rfidreader.data.mappers.toModel
import ru.meseen.rfidreader.data.model.LogModel
import ru.meseen.rfidreader.ui.base.BaseViewModel
import javax.inject.Inject

/**
 * @author Vyacheslav Doroshenko
 */
@HiltViewModel
class LogViewModel @Inject constructor(
    private val handle: SavedStateHandle,
    private val repository: LogRepository,
) : BaseViewModel() {

    val logs: Flow<PagingData<LogModel>> =
        Pager(config = PagingConfig(pageSize = 20, prefetchDistance = 2),
            pagingSourceFactory = { repository.loadLogs() }
        ).flow.map { pagininData ->
            pagininData.map { entity ->
                entity.toModel()
            }
        }.cachedIn(viewModelScope)

    fun clearLog() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.clearLogs()
        }
    }

}