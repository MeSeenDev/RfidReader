package ru.meseen.rfidreader.ui.main

import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.meseen.rfidreader.ui.base.BaseViewModel
import javax.inject.Inject

/**
 * @author Vyacheslav Doroshenko
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val handle: SavedStateHandle
) : BaseViewModel()