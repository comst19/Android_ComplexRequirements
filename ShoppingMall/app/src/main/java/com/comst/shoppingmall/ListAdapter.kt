package com.comst.shoppingmall

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.comst.shoppingmall.model.ListItem
import com.comst.shoppingmall.viewholder.BindingViewHolder
import com.comst.shoppingmall.viewholder.ViewHolderGenerator

class ListAdapter : ListAdapter<ListItem, BindingViewHolder<*>>(DiffCallback()) {

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return item?.viewType?.ordinal ?: -1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<*> {
        return ViewHolderGenerator.get(parent, viewType)
    }

    override fun onBindViewHolder(holder: BindingViewHolder<*>, position: Int) {
        val item = getItem(position)
        if (item != null){
            holder.bind(item)
        }
    }
}