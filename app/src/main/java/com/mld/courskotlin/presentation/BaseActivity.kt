package com.mld.courskotlin.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    abstract fun displayDialog()
    abstract fun setTitle(title: String)
}