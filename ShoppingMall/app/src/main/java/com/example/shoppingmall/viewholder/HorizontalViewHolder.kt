package com.example.shoppingmall.viewholder

import com.example.shoppingmall.ListAdapter
import com.example.shoppingmall.databinding.ItemHorizontalBinding
import com.example.shoppingmall.model.Horizontal
import com.example.shoppingmall.model.ListItem

class HorizontalViewHolder(
    private val binding : ItemHorizontalBinding
) : BindingViewHolder<ItemHorizontalBinding>(binding){
    private val adapter = ListAdapter()

    init {
        binding.listView.adapter = adapter
    }

    override fun bind(item : ListItem){
        super.bind(item)
        item as Horizontal
        binding.titleTextView.text = item.title
        adapter.submitList(item.items)
    }
}