package ru.meseen.rfidreader.ui.main

import android.content.Intent
import android.nfc.NfcAdapter
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigationrail.NavigationRailView
import dagger.hilt.android.AndroidEntryPoint
import ru.meseen.rfidreader.R
import ru.meseen.rfidreader.bytes2Hex
import ru.meseen.rfidreader.hex2Ascii
import ru.meseen.rfidreader.ui.base.BaseActivity

/**
 * @author Vyacheslav Doroshenko
 */
@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val navController by lazy { Navigation.findNavController(this, R.id.container) }

    val mNfcAdapter: NfcAdapter by lazy { NfcAdapter.getDefaultAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navigationRail: NavigationRailView = findViewById(R.id.navigation_rail)
        navigationRail.setupWithNavController(navController)

        intent?.let { onNewIntent(it) }
    }

    override fun onNewIntent(intent: Intent?) {
        intent?.let {
            Log.wtf(TAG, "onNewIntent: $it")
            Toast.makeText(this, "Пришёл Интент \n ${it.action}", Toast.LENGTH_SHORT).show()

            val tag = it.getParcelableExtra<Tag>(NfcAdapter.EXTRA_TAG)

            Log.d(TAG, "onNewIntent:tag ${tag?.id?.bytes2Hex?.hex2Ascii}")

            Toast.makeText(this, " tag $tag", Toast.LENGTH_SHORT).show()
        }
        super.onNewIntent(intent)
    }


    companion object {
        private const val TAG = "MainActivity"
    }
}