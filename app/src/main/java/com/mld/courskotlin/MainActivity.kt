package com.mld.courskotlin

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ArrayAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mld.courskotlin.presentation.BaseActivity
import com.mld.courskotlin.presentation.BaseFragment
import com.mld.courskotlin.presentation.news.creation.CreationNewsFragment
import com.mld.courskotlin.presentation.news.list.ListNewsAdapter
import com.mld.courskotlin.presentation.news.list.ListNewsFragment
import com.mld.courskotlin.util.TestUtils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_list_news.*

class MainActivity : BaseActivity(), MyClick {
    override fun setTitle(title: String) {
        supportActionBar?.title = title
    }

    companion object {
        const val TOTO = "TOTO"
    }

    private val TAG = "TAG"
    private lateinit var TAG2: String
    private var TAG3: String? = null

    private val tabs = mapOf(
        R.id.list_news to ListNewsFragment(),
        R.id.create_news to ListNewsFragment()
    )

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            setActiveFragment(item.itemId)
            true
        }

    private fun setActiveFragment(selected: Int) {
        when (selected) {
            R.id.list_news -> {
                changeFragment(ListNewsFragment.newInstance("Frg 1"))
            }
            R.id.create_news -> {
                changeFragment(CreationNewsFragment())
            }
        }
    }

    private fun changeFragment(fragment: BaseFragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fl_list_fragment, fragment)
            .commit()
    }


    override fun onClick() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun displayMessage(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun displayDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val t = test2()

        val color = getColor(COLOR.BLACK)
        color?.let {
            tv_hello.text = t
        } ?: run {
            tv_hello.text = "unknown"
        }

        val newsList = TestUtils.createNewsDataTest()
        for (n in newsList) {
            Log.e(n.title, n.descShort)
            n.images?.let {
                for (img in it) {
                    Log.e("image ", img)
                }
            } ?: run {
                Log.e("image :", "NO IMAGES")
            }
        }


        newsList.forEachIndexed { index, news ->
            Log.e("index $index", "${news.title} - ${news.descShort}") // String template
            news.images?.let {
                for (img in it) {
                    Log.e("image ", img)
                }
            } ?: run {
                Log.e("image :", "NO IMAGES")
            }
        }

        Handler()
            .postDelayed({
                fl_list_fragment.removeAllViews()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fl_list_fragment, ListNewsFragment())
                    .commit()
            }, 2000)


        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

    }


    fun test1() {
        Log.e("TAG", "message")
        //faire une boucle sur les colors
    }

    fun test2(): String {
        return "toto"
    }

    private fun getColor(value: COLOR): Int? {
        return when (value) {
            COLOR.BLUE -> {
                Log.e(TAG, COLOR.BLUE.text)
                0
            }
            COLOR.BLACK -> 1
            COLOR.RED -> 2
        }
    }
}

interface MyClick {
    fun onClick()
    fun displayMessage(message: String)
}

enum class COLOR(val text: String) {
    BLUE("bleue"),
    BLACK("noir"),
    RED("rouge")
}
