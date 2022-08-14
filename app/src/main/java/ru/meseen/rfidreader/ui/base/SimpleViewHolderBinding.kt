package ru.meseen.rfidreader.ui.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @author Vyacheslav Doroshenko
 */
abstract class SimpleViewHolderBinding<Model>(view: View) : RecyclerView.ViewHolder(view),
    BindView<Model>

interface BindView<Model> {
    fun bind(model: Model)
}