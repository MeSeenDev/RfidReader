package ru.meseen.rfidreader.ui.reader

import android.nfc.NfcAdapter
import android.nfc.Tag
import android.nfc.tech.MifareClassic
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.meseen.rfidreader.bytes2Hex
import ru.meseen.rfidreader.databinding.FragmentReaderBinding
import ru.meseen.rfidreader.ui.base.BaseFragment
import ru.meseen.rfidreader.ui.main.MainActivity


/**
 * @author Vyacheslav Doroshenko
 */
@AndroidEntryPoint
class ReaderFragment : BaseFragment() {

    private var _binding: FragmentReaderBinding? = null
    private val binding get() = _binding!!


    private val vm: ReaderViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReaderBinding.inflate(inflater, container, false)

        vm.start()

        binding.scan.setOnClickListener {
            vm.addToLog("Start Scan")
            lifecycleScope.launch {
                delay(2000)
                vm.addToLog("Stop Scan")


            }

        }
        (activity as MainActivity).intent?.apply {
            if( NfcAdapter.ACTION_TECH_DISCOVERED == action){
                vm.addToLog("Intent TECH_DISCOVERED")
                lifecycleScope.launch(Dispatchers.IO) {
                    getParcelableExtra<Tag>(NfcAdapter.EXTRA_TAG)?.let{ tag->
                        vm.addToLog(" TAG:id\n ${tag.id.bytes2Hex}")
                    }
                }

            }


        }
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}