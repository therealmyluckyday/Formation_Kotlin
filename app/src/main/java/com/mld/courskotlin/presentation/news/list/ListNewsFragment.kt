package com.mld.courskotlin.presentation.news.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mld.courskotlin.R
import com.mld.courskotlin.presentation.BaseActivity
import com.mld.courskotlin.presentation.BaseFragment
import kotlinx.android.synthetic.main.fragment_list_news.*

class ListNewsFragment : BaseFragment() {

    lateinit var vm: ListNewsViewModel
    lateinit var adapter: ListNewsAdapter

    companion object {
        var argKey = "title"
        fun newInstance(title: String): ListNewsFragment {
            return ListNewsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(argKey, title)
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
        vm = ViewModelProviders.of(this).get(ListNewsViewModel::class.java)

        progress.visibility = VISIBLE

        bt_valider.setOnClickListener {
            Log.e("TAG", "click")
        }

        arguments?.get(argKey)?.let {
            setTitle(it as String)
        }

        adapter = ListNewsAdapter(emptyList()) { position, news ->
            Toast.makeText(context, position.toString(), 2).show()
            //val fragment = DetailNewsFragment.newInstance(news)
            //TODO generate a ui bug
//            fragmentManager?.beginTransaction()
//                ?.replace(R.id.fl_list_fragment, fragment)
//                ?.addToBackStack(null)
//                ?.commit()

            //changeFragment(fragment)

            //with activity
            DetailNewsActivity.start(activity as BaseActivity, news)

        }
        recycler_view.adapter = adapter
        val manager = LinearLayoutManager(context)
        recycler_view.layoutManager = manager

//        vm.listNews.observe(this, Observer {
//
//        })
//
//        vm.fetchNews()

//        vm.fetchNews2().observe(this, Observer {
//            adapter.updateList(it)
//            progress.visibility = GONE
//        })


        vm.fetchNews3(context!!).observe(this, Observer {
            adapter.updateList(it)
            progress.visibility = GONE
        })
    }
}