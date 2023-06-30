package com.example.shoppingmall

import com.example.shoppingmall.model.ListItem
import com.example.shoppingmall.model.ViewType

data class Coupon(
    val imageUrl : String,
    val name : String,
    val coupon : String
) : ListItem {
    override val viewType: ViewType
        get() = ViewType.COUPON

}
