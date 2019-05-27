package com.mld.courskotlin.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mld.courskotlin.data.model.News

@Database(
    version = 1,
    entities = [
        News::class
    ]
)

@TypeConverters(Converter::class)
abstract class MyDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDAO
}