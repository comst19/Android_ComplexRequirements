package com.comst.blindapp.data.model.entitiy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity("Content")
data class ContentEntity (

    @PrimaryKey(false)
    val id : Int,

    @ColumnInfo
    var title : String,

    @ColumnInfo
    var content : String,

    @ColumnInfo
    var category : String,

    @ColumnInfo
    var createdDate : Date,

    @ColumnInfo
    val likeCount : Int,

    @ColumnInfo
    val commentCount : Int,

    @ColumnInfo
    val viewCount : Int
) : java.io.Serializable