package ru.meseen.rfidreader.ui.reader

import android.content.Intent
import android.nfc.NfcAdapter
import android.nfc.tech.Ndef
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.meseen.rfidreader.databinding.FragmentReaderBinding
import ru.meseen.rfidreader.ui.base.BaseFragment


/**
 * @author Vyacheslav Doroshenko
 */
@AndroidEntryPoint
class ReaderFragment : BaseFragment() {

    private var _binding: FragmentReaderBinding? = null
    private val binding get() = _binding!!


    private val vm : ReaderViewModel by viewModels()

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
        return binding.root
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}