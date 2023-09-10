package com.comst.shoppingmallapp

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.comst.shoppingmallapp.model.ListItem
import com.comst.shoppingmallapp.viewholder.BindingViewHolder
import com.comst.shoppingmallapp.viewholder.ViewHolderGenerator

class PagingListAdapter :
    PagingDataAdapter<ListItem, BindingViewHolder<*>>(DiffCallback()){

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return item?.viewType?.ordinal ?: -1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<*> {
        return ViewHolderGenerator.get(parent,viewType)
    }

    override fun onBindViewHolder(holder: BindingViewHolder<*>, position: Int) {
        val item = getItem(position)
        if (item != null){
            holder.bind(item)
        }
    }
}