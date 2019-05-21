package com.mld.courskotlin.presentation

import androidx.appcompat.app.AppCompatActivity
import com.mld.courskotlin.R

abstract class BaseActivity : AppCompatActivity() {

    abstract fun displayDialog()
    abstract fun setTitle(title: String)
    fun changeFragmentFromFragment(fragment: BaseFragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_list_fragment, fragment)
            .addToBackStack(null)
            .commit()
    }
}