package ru.meseen.rfidreader.data

import android.content.Context
import android.nfc.Tag
import android.nfc.tech.MifareClassic

/**
 * @author Vyacheslav Doroshenko
 */
class MCReader private constructor(tag: Tag) {

    private val mifareClassic by lazy { MifareClassic.get(tag) }


    companion object{

        fun checkForTagAndCreateReader(tag: Tag): MCReader{
            return MCReader(tag)
        }

    }

}