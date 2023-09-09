package com.comst.shoppingmallapp.viewholder

import com.comst.shoppingmallapp.ListAdapter
import com.comst.shoppingmallapp.databinding.ItemViewpagerBinding
import com.comst.shoppingmallapp.model.ListItem
import com.comst.shoppingmallapp.model.ViewPager

class ViewPagerViewHolder(
    binding : ItemViewpagerBinding
) : BindingViewHolder<ItemViewpagerBinding>(binding){

    private val adapter = ListAdapter()

    init {
        binding.viewpager.adapter = adapter
    }

    override fun bind(item: ListItem) {
        super.bind(item)
        item as ViewPager
        adapter.submitList(item.items)
    }
}