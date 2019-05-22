package com.mld.courskotlin.presentation

import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    fun setTitle(title: String) {
        (activity as BaseActivity).setTitle(title)
    }

    fun changeFragment(fragment: BaseFragment) {
        (activity as BaseActivity).changeFragmentFromFragment(fragment)
    }

}