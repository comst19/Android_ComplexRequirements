package com.comst.shoppingmallapp.model

data class Coupon(
    val imageUrl : String,
    val name : String,
    val coupon : String
) : ListItem{
    override val viewType: ViewType
        get() = ViewType.COUPON

}
