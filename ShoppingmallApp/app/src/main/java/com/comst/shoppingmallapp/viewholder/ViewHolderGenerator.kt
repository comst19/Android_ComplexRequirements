package com.comst.shoppingmallapp.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.comst.shoppingmallapp.databinding.ItemEmptyBinding
import com.comst.shoppingmallapp.model.ViewType

object ViewHolderGenerator {

    fun get(
        parent : ViewGroup,
        viewType : Int
    ) : BindingViewHolder<*>{
        return when(viewType){
            ViewType.VIEW_PAGER.ordinal -> ViewPagerViewHolder(parent.toBinding())
            ViewType.HORIZONTAL.ordinal -> HorizontalViewHolder(parent.toBinding())
            ViewType.FULL_AD.ordinal -> FullAdViewHolder(parent.toBinding())
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