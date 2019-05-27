package com.mld.courskotlin.data.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mld.courskotlin.data.model.News

class Converter {

    @TypeConverter
    fun fromListString(list: List<String>?): String? {
        if (list == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<String>>() {
        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    fun toListString(value: String?): List<String>? {
        if (value == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<String>>() {
        }.type
        return gson.fromJson(value, type)
    }

}