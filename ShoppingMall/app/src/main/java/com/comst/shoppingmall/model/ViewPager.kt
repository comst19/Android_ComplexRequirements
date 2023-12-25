package com.comst.shoppingmall.model

import com.comst.shoppingmall.model.ListItem


data class ViewPager(
    val items : List<ListItem>
) : ListItem {
    override val viewType: ViewType
        get() = ViewType.VIEW_PAGER
}
