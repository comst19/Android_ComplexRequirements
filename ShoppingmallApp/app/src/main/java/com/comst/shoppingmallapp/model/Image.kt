package com.comst.shoppingmallapp.model

data class Image(
    val imageUrl : String
) : ListItem{
    override val viewType: ViewType
        get() = ViewType.IMAGE

}