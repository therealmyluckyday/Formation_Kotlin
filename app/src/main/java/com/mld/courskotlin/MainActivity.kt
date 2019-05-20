package com.mld.courskotlin

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ArrayAdapter
import com.mld.courskotlin.presentation.BaseActivity
import com.mld.courskotlin.presentation.news.list.ListNewsFragment
import com.mld.courskotlin.util.TestUtils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_list_news.*

class MainActivity : BaseActivity(), MyClick {

    companion object {
        const val TOTO = "TOTO"
    }

    private val TAG = "TAG"
    private lateinit var TAG2: String
    private var TAG3: String? = null

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
                    .addToBackStack(null)
                    .commit()
            },2000)



    }


    fun test1() {
        Log.e("TAG", "message")
        //faire une boucle sur les colors
    }

    fun test2(): String {
        return "toto"
    }

    private fun createAdapter() {
        //val adapter = ArrayAdapter(context = this, R.layout.adapter_list_news, R.id.recycler_view)
        //recycler_view.adapter =
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
