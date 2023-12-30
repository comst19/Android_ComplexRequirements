package com.comst.blindapp.presenter.ui.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.comst.blindapp.databinding.ItemContentBinding
import com.comst.blindapp.domain.model.Content
import com.comst.blindapp.presenter.ui.MainActivity

class ContentViewHolder(
    private val binding : ItemContentBinding,
    private val handler : MainActivity.Handler
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item : Content){
        binding.item = item
        binding.handler = handler
    }
}