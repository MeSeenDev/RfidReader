package ru.meseen.rfidreader.ui.main

import android.app.Activity
import android.app.PendingIntent
import android.content.Intent
import android.nfc.NfcAdapter
import android.nfc.tech.NfcA
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigationrail.NavigationRailView
import dagger.hilt.android.AndroidEntryPoint
import ru.meseen.rfidreader.R
import ru.meseen.rfidreader.ui.base.BaseActivity

/**
 * @author Vyacheslav Doroshenko
 */
@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val navController by lazy { Navigation.findNavController(this, R.id.container) }

    val mNfcAdapter: NfcAdapter by lazy {NfcAdapter.getDefaultAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navigationRail: NavigationRailView = findViewById(R.id.navigation_rail)
        navigationRail.setupWithNavController(navController)

        intent?.let { onNewIntent(it) }
    }

    override fun onNewIntent(intent: Intent?) {
        Log.wtf(TAG, "onNewIntent: $intent")
        Toast.makeText(this, "Пришёл Интент \n ${intent?.action}", Toast.LENGTH_SHORT).show()
    }



    companion object {
        private const val TAG = "MainActivity"
    }
}