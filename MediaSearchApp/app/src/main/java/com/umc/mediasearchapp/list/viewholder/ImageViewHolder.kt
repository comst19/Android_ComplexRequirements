package com.umc.mediasearchapp.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.umc.mediasearchapp.databinding.ItemImageBinding
import com.umc.mediasearchapp.model.ImageItem
import com.umc.mediasearchapp.model.ListItem

class ImageViewHolder(
    private val binding : ItemImageBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item : ListItem){
        item as ImageItem
        binding.item = item
    }
}