package com.comst.shoppingmallapp.viewholder

import com.comst.shoppingmallapp.ListAdapter
import com.comst.shoppingmallapp.databinding.ItemHorizontalBinding
import com.comst.shoppingmallapp.model.Horizontal
import com.comst.shoppingmallapp.model.ListItem

class HorizontalViewHolder(
    private val binding : ItemHorizontalBinding
) : BindingViewHolder<ItemHorizontalBinding>(binding){

    private val adapter = ListAdapter()

    init {
        binding.listView.adapter = adapter
    }

    override fun bind(item: ListItem) {
        super.bind(item)
        item as Horizontal
        binding.titleTextView.text = item.title
        adapter.submitList(item.items)
    }
}