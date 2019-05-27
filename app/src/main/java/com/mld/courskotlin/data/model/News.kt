package com.mld.courskotlin.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
data class News(
    @PrimaryKey
    val id: Int,
    val title: String,
    @SerializedName("desc_short")
    val descShort: String,
    @SerializedName("desc_long")
    val descLong: String,
    val images: List<String>? = null,
    @SerializedName("url_path")
    val image: String? = null
) : Serializable