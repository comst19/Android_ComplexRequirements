package com.example.walletservice

import androidx.recyclerview.widget.RecyclerView
import com.example.walletservice.databinding.ItemDetailBinding
import com.example.walletservice.model.DetailItem

class DetailViewHolder(private val binding : ItemDetailBinding) : RecyclerView.ViewHolder(binding.root)  {

    fun bind(item : DetailItem){
        binding.item = item
    }
}