package com.mld.courskotlin.presentation.news.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.mld.courskotlin.R
import com.mld.courskotlin.presentation.BaseFragment
import com.mld.courskotlin.util.TestUtils
import kotlinx.android.synthetic.main.fragment_list_news.*

class ListNewsFragment : BaseFragment() {

    companion object {
        var argKey = "title"
        fun newInstance(argName: String): ListNewsFragment {
            return ListNewsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(argKey, argName)
                }
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bt_valider.setOnClickListener {
            Log.e("TAG", "click")
        }

        arguments?.get(argKey)?.let {
            setTitle(it as String)
        }

        val adapter = ListNewsAdapter(TestUtils.createNewsDataTest())
        recycler_view.adapter = adapter
        val manager = LinearLayoutManager(context)
        recycler_view.layoutManager = manager
    }
}