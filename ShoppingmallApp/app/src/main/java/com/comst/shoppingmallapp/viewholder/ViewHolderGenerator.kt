package com.comst.shoppingmallapp.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.comst.shoppingmallapp.databinding.ItemEmptyBinding

object ViewHolderGenerator {

    fun get(
        parent : ViewGroup,
        viewType : Int
    ) : BindingViewHolder<*>{
        return when(viewType){
            else -> ItemViewHolder(parent.toBinding())
        }
    }

    class ItemViewHolder(binding : ItemEmptyBinding) : BindingViewHolder<ItemEmptyBinding>(binding)

    private inline fun <reified  V : ViewBinding> ViewGroup.toBinding() : V {
        return V::class.java.getMethod(
            "inflate",
            LayoutInflater::class.java,
            ViewGroup::class.java,
            Boolean::class.java
        ).invoke(null, LayoutInflater.from(context), this, false) as V
    }
}