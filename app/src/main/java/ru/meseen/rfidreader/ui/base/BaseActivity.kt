package ru.meseen.rfidreader.ui.base

import androidx.appcompat.app.AppCompatActivity
import ru.meseen.rfidreader.data.NfcObserver


/**
 * @author Vyacheslav Doroshenko
 */
open class BaseActivity : AppCompatActivity() {

 val nfvObserver by lazy {  NfcObserver(this)}



}