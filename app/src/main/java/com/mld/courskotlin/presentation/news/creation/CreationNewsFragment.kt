package com.mld.courskotlin.presentation.news.creation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mld.courskotlin.R
import com.mld.courskotlin.presentation.BaseFragment
import com.mld.courskotlin.presentation.news.list.ListNewsFragment
import kotlinx.android.synthetic.main.fragment_creation_news.*

class CreationNewsFragment : BaseFragment() {

    lateinit var vm: CreationNewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_creation_news, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm = ViewModelProviders.of(this).get(CreationNewsViewModel::class.java)

        bt_valider.setOnClickListener {
            postNews()
        }
    }

    private fun postNews() {

        val title = et_title.text
        val descShort = til_desc.editText?.text


        vm.postNews(title.toString(), descShort = descShort?.toString()).observe(this, Observer {

            it.errorCode?.let {
                Toast.makeText(context, "une erreur est survenue", 2).show()
            } ?: run {
                Toast.makeText(context, "News Créée", 2).show()
                changeFragment(ListNewsFragment.newInstance("title"))
            }

        })
    }

}