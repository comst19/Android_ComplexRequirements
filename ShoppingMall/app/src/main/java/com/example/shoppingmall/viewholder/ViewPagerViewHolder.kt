package com.example.shoppingmall.viewholder

import com.example.shoppingmall.ListAdapter
import com.example.shoppingmall.databinding.ItemViewpagerBinding
import com.example.shoppingmall.model.ListItem
import com.example.shoppingmall.model.ViewPager

class ViewPagerViewHolder(
    binding : ItemViewpagerBinding
) : BindingViewHolder<ItemViewpagerBinding>(binding){

    private val adapter = ListAdapter()

    init {
        binding.viewpager.adapter = adapter
    }

    override fun bind(item : ListItem){
        super.bind(item)
        item as ViewPager
        adapter.submitList(item.items)
    }
}