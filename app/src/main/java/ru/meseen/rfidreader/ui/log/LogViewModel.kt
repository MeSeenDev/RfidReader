package ru.meseen.rfidreader.ui.log

import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.meseen.rfidreader.ui.base.BaseViewModel
import javax.inject.Inject

/**
 * @author Vyacheslav Doroshenko
 */
@HiltViewModel
class LogViewModel @Inject constructor(
    private val handle: SavedStateHandle
) : BaseViewModel() {


}