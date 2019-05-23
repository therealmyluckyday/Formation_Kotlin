package com.mld.courskotlin.data.api

import com.google.gson.annotations.SerializedName
import com.mld.courskotlin.data.model.News

open class ApiResponse {

        @SerializedName("status")
        val httpStatus: Int = 0
        @SerializedName("message")
        val errorMessage: String? = null // for debugging
        @SerializedName("error")
        var errorCode: Int = 0

    class ListNewsApiResponse : ApiResponse() {
        @SerializedName("news")
        val news: List<News>? = null
    }
}