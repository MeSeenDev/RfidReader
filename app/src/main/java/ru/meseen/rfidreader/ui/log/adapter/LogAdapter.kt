package ru.meseen.rfidreader.ui.log.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import ru.meseen.rfidreader.data.model.LogModel
import ru.meseen.rfidreader.databinding.LogItemBinding
import ru.meseen.rfidreader.ui.base.SimpleViewHolderBinding
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author Vyacheslav Doroshenko
 */
class LogAdapter : PagingDataAdapter<LogModel, SimpleViewHolderBinding<LogModel>>(LOG_MATCHER) {


    override fun onBindViewHolder(holder: SimpleViewHolderBinding<LogModel>, position: Int) {
        getItem(position)?.let { model ->
            holder.bind(model)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SimpleViewHolderBinding<LogModel> =
        LogViewHolder(LogItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    inner class LogViewHolder(private val binding: LogItemBinding) :
        SimpleViewHolderBinding<LogModel>(binding.root) {

        val dateFormat =
            SimpleDateFormat("MM-dd HH:mm:ss", Locale.getDefault()).apply {
                timeZone = TimeZone.getDefault()
            }

        override fun bind(model: LogModel) {
            binding.message.text = model.message
            binding.date.text = dateFormat.format(model.date)
        }
    }

    companion object {
        private val LOG_MATCHER = object : DiffUtil.ItemCallback<LogModel>() {
            override fun areItemsTheSame(oldItem: LogModel, newItem: LogModel): Boolean =
                oldItem.date == newItem.date

            override fun areContentsTheSame(oldItem: LogModel, newItem: LogModel): Boolean =
                oldItem == newItem

            override fun getChangePayload(oldItem: LogModel, newItem: LogModel): Any = Any()
        }
    }
}