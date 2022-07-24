package ru.meseen.rfidreader.ui.reader

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import ru.meseen.rfidreader.ui.base.BaseViewModel
import javax.inject.Inject

/**
 * @author Vyacheslav Doroshenko
 */
@HiltViewModel
class ReaderViewModel @Inject constructor(
    @ApplicationContext context: Context,
    private val handle: SavedStateHandle
) : BaseViewModel() {

    fun start(){

    }
}