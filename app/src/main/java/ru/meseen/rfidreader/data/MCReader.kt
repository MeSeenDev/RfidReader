package ru.meseen.rfidreader.data

import android.content.Context
import android.nfc.Tag
import android.nfc.tech.MifareClassic
import ru.meseen.rfidreader.ui.reader.IReader

/**
 * @author Vyacheslav Doroshenko
 */
class MCReader private constructor(tag: Tag): IReader {


    private val reader: MifareClassic by lazy { MifareClassic.get(tag) }


    override fun connect() {

    }

    override fun disconnect() {

    }



    companion object{

        fun checkForTagAndCreateReader(tag: Tag): MCReader{
            return MCReader(tag)
        }

    }

}