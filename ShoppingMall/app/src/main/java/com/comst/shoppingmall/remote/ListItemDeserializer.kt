package com.comst.shoppingmall.remote

import com.comst.shoppingmall.model.Coupon
import com.comst.shoppingmall.model.Empty
import com.comst.shoppingmall.model.FullAd
import com.comst.shoppingmall.model.Horizontal
import com.comst.shoppingmall.model.Image
import com.comst.shoppingmall.model.ListItem
import com.comst.shoppingmall.model.Sale
import com.comst.shoppingmall.model.SellItem
import com.comst.shoppingmall.model.ViewPager
import com.comst.shoppingmall.model.ViewType
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class ListItemDeserializer : JsonDeserializer<ListItem> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): ListItem {

        val viewTypeName = json.asJsonObject.getAsJsonPrimitive("viewType").asString
        val gson = GsonBuilder()
            .registerTypeAdapter(ListItem::class.java, ListItemDeserializer())
            .create()

        return try {
            when(viewTypeName){
                ViewType.VIEW_PAGER.name -> gson.fromJson(json, ViewPager::class.java)
                ViewType.HORIZONTAL.name -> gson.fromJson(json, Horizontal::class.java)
                ViewType.FULL_AD.name -> gson.fromJson(json, FullAd::class.java)

                ViewType.SELL_ITEM.name -> gson.fromJson(json, SellItem::class.java)
                ViewType.IMAGE.name -> gson.fromJson(json, Image::class.java)
                ViewType.SALE.name -> gson.fromJson(json, Sale::class.java)
                ViewType.COUPON.name -> gson.fromJson(json, Coupon::class.java)
                else -> gson.fromJson(json, Empty::class.java)
            }
        } catch ( e : Exception){
            gson.fromJson(json, Empty::class.java)
        }
    }
}