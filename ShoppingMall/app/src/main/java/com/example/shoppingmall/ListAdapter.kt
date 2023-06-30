package com.example.shoppingmall

import android.view.ViewGroup
import com.example.shoppingmall.model.ListItem
import com.example.shoppingmall.viewholder.BindingViewHolder
import com.example.shoppingmall.viewholder.ViewHolderGenerator

class ListAdapter : androidx.recyclerview.widget.ListAdapter<ListItem, BindingViewHolder<*>>(DiffCallback()){

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return item?.viewType?.ordinal ?: -1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<*> {
        return ViewHolderGenerator.get(parent, viewType)
    }

    override fun onBindViewHolder(holder: BindingViewHolder<*>, position: Int) {
        val item = getItem(position)
        if(item != null){
            holder.bind(item)
        }
    }

}