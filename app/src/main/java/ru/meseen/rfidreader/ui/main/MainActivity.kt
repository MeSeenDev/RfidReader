package ru.meseen.rfidreader.ui.main

import android.content.Intent
import android.nfc.NfcAdapter
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigationrail.NavigationRailView
import dagger.hilt.android.AndroidEntryPoint
import ru.meseen.rfidreader.R
import ru.meseen.rfidreader.ui.base.BaseActivity
import ru.meseen.rfidreader.ui.log.LogFragmentDirections
import ru.meseen.rfidreader.ui.reader.ReaderFragmentDirections

/**
 * @author Vyacheslav Doroshenko
 */
@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val navController by lazy { Navigation.findNavController(this, R.id.container) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navigationRail: NavigationRailView = findViewById(R.id.navigation_rail)
        navigationRail.setupWithNavController(navController)
    }

    companion object{
        private const val TAG = "MainActivity"
    }
}