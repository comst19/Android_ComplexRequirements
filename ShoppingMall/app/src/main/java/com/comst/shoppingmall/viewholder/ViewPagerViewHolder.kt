package com.comst.shoppingmall.viewholder

import com.comst.shoppingmall.ListAdapter
import com.comst.shoppingmall.databinding.ItemViewPagerBinding
import com.comst.shoppingmall.model.ListItem
import com.comst.shoppingmall.model.ViewPager

class ViewPagerViewHolder(
    binding : ItemViewPagerBinding
) : BindingViewHolder<ItemViewPagerBinding>(binding) {

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