package ru.meseen.rfidreader.ui.log

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ru.meseen.rfidreader.R
import ru.meseen.rfidreader.databinding.FragmentLogBinding
import ru.meseen.rfidreader.ui.base.BaseFragment
import ru.meseen.rfidreader.ui.log.adapter.LogAdapter

/**
 * @author Vyacheslav Doroshenko
 */
@AndroidEntryPoint
class LogFragment : BaseFragment() {


    private var _binding: FragmentLogBinding? = null

    private val binding get() = _binding!!
    private val vm: LogViewModel by viewModels()

    private val adapter = LogAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLogBinding.inflate(inflater, container, false)

        binding.toolbar.setOnMenuItemClickListener {
        when(it.itemId){
            R.id.clear ->{
                vm.clearLog()
                true
            }
            else -> false
        }
        }
        binding.apply {
            logList.adapter = adapter
        }


        viewLifecycleOwner.lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.CREATED) {
                vm.logs.collectLatest(adapter::submitData)
            }
        }


        return binding.root

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}