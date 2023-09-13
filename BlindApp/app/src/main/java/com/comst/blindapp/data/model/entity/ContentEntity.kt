package com.comst.blindapp.data.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity("Content")
data class ContentEntity(

    // 서버에서 받아오는 id를 사용할 예정
    @PrimaryKey(false)
    val id : Int,

    @ColumnInfo
    var title : String,

    @ColumnInfo
    var content : String,

    @ColumnInfo
    var category : String,

    @ColumnInfo
    val createdDate : Date,

    @ColumnInfo
    val likeCount : Int,

    @ColumnInfo
    val commentCount : Int,

    @ColumnInfo
    val viewCount : Int
) : java.io.Serializable
