package ru.meseen.rfidreader.ui.reader

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.meseen.rfidreader.data.LogRepository
import ru.meseen.rfidreader.data.model.LogModel
import ru.meseen.rfidreader.ui.base.BaseViewModel
import java.util.*
import javax.inject.Inject

/**
 * @author Vyacheslav Doroshenko
 */
@HiltViewModel
class ReaderViewModel @Inject constructor(
    @ApplicationContext context: Context,
    private val handle: SavedStateHandle,
    private val logRepository: LogRepository,
) : BaseViewModel() {

    fun start(){

    }

    fun addToLog(message: String){
        viewModelScope.launch(Dispatchers.IO) {
            logRepository.insert(LogModel(message, Date()))
        }
    }

}