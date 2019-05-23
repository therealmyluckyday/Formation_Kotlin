package com.mld.courskotlin.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class News(
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