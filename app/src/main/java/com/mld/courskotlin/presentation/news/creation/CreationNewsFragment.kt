package com.mld.courskotlin.presentation.news.creation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mld.courskotlin.R
import com.mld.courskotlin.presentation.BaseFragment

class CreationNewsFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_creation_news, container, false)
    }
}