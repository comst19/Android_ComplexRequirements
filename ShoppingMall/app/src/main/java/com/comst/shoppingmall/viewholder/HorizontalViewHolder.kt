package com.comst.shoppingmall.viewholder

import com.comst.shoppingmall.ListAdapter
import com.comst.shoppingmall.databinding.ItemHorizontalBinding
import com.comst.shoppingmall.model.Horizontal
import com.comst.shoppingmall.model.ListItem

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