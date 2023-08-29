package com.umc.mediasearchapp.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.umc.mediasearchapp.databinding.ItemVideoBinding
import com.umc.mediasearchapp.model.ListItem
import com.umc.mediasearchapp.model.VideoItem

class VideoViewHolder(
    private val binding : ItemVideoBinding
) : RecyclerView.ViewHolder(binding.root){

    fun bind(item : ListItem){
        item as VideoItem
        binding.item = item
    }
}