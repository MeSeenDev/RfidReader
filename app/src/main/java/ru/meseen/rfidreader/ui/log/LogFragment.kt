package ru.meseen.rfidreader.ui.log

import android.content.Context
import android.content.Intent
import android.nfc.NfcAdapter
import android.nfc.Tag
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.meseen.rfidreader.databinding.FragmentLogBinding
import ru.meseen.rfidreader.ui.base.BaseFragment
import ru.meseen.rfidreader.ui.reader.ReaderViewModel
import java.util.*

/**
 * @author Vyacheslav Doroshenko
 */
@AndroidEntryPoint
class LogFragment : BaseFragment() {


    private var _binding: FragmentLogBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val vm: ReaderViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLogBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}