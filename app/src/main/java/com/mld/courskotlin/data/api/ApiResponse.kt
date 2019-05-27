package com.mld.courskotlin.data.api

import com.google.gson.annotations.SerializedName
import com.mld.courskotlin.data.model.News

open class ApiResponse {

        @SerializedName("message")
        val errorMessage: String? = null // for debugging
        @SerializedName("error")
        var errorCode: Int? = null

    class PostNewsApiResponse : ApiResponse() {
        @SerializedName("news")
        val news: News? = null
    }
}