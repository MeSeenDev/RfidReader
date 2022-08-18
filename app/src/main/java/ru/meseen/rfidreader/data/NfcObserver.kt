package ru.meseen.rfidreader.data

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.nfc.NfcAdapter
import androidx.activity.ComponentActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * @author Vyacheslav Doroshenko
 */
class NfcObserver(activity: ComponentActivity) {

    val nfcStatus: LiveData<Boolean>
        get() = _nfcStatus
    private val _nfcStatus = MutableLiveData<Boolean>();

    private val lifecycleObserver =
        object : DefaultLifecycleObserver {
            override fun onCreate(owner: LifecycleOwner) {
                val filter = IntentFilter(NfcAdapter.ACTION_ADAPTER_STATE_CHANGED)
                activity.registerReceiver(nfcStateReceiver, filter)
                super.onCreate(owner)
            }

            override fun onDestroy(owner: LifecycleOwner) {
                activity.unregisterReceiver(nfcStateReceiver)
                super.onDestroy(owner)
            }
        }


    init {
        activity.lifecycle.addObserver(lifecycleObserver)
    }

    private val nfcStateReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            intent?.action?.let { actionIntent ->

                if (actionIntent == NfcAdapter.ACTION_ADAPTER_STATE_CHANGED) {
                    val state = intent.getIntExtra(
                        NfcAdapter.EXTRA_ADAPTER_STATE,
                        NfcAdapter.STATE_OFF
                    )
                    when (state) {
                        NfcAdapter.STATE_OFF -> {
                            _nfcStatus.postValue(false)
                        }
                        NfcAdapter.STATE_ON -> {
                            _nfcStatus.postValue(true)
                        }
                    }
                }

            }
        }

    }

}