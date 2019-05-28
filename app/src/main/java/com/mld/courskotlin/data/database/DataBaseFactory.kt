package com.mld.courskotlin.data.database

import android.content.Context
import androidx.room.Room

object DataBaseFactory {


    lateinit var myDatabase : MyDatabase

    fun initialize(appContext : Context) {
        myDatabase = Room.databaseBuilder(appContext, MyDatabase::class.java, "myDB")
            .fallbackToDestructiveMigration()
            .build()
    }
}