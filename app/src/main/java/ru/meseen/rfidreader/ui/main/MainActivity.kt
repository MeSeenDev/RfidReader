package ru.meseen.rfidreader.ui.main

import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import ru.meseen.rfidreader.R
import ru.meseen.rfidreader.ui.base.BaseActivity

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}