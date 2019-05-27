package com.mld.courskotlin

import android.app.Application
import com.mld.courskotlin.data.database.DataBaseFactory

class MyApplication :Application() {
    override fun onCreate() {
        super.onCreate()

        DataBaseFactory.initialize(applicationContext)
    }
}