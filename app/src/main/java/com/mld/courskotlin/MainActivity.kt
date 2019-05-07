package com.mld.courskotlin

import android.os.Bundle
import android.util.Log
import com.mld.courskotlin.presentation.BaseActivity
import com.mld.courskotlin.util.TestUtils
import kotlinx.android.synthetic.main.activity_main.*

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

        val news = TestUtils.createNewsDataTest()
        for (n in news) {
            Log.e(n.title, n.descShort)
            n.images?.let {
                for (img in it) {
                    Log.e("image ", img)
                }
            } ?: run {
                Log.e("image :", "NO IMAGES")
            }
        }


        news.forEachIndexed { index, news ->
            Log.e("index $index", "${news.title} - ${news.descShort}") // String template
            news.images?.let {
                for (img in it) {
                    Log.e("image ", img)
                }
            } ?: run {
                Log.e("image :", "NO IMAGES")
            }
        }
    }


    fun test1() {
        Log.e("TAG" , "message")
        //faire une boucle sur les colors
    }

    fun test2() : String {
        return "toto"
    }

    private fun getColor(value : COLOR) : Int? {
        return when(value) {
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
    fun displayMessage(message : String)
}

enum class COLOR(val text : String) {
    BLUE("bleue"),
    BLACK("noir"),
    RED("rouge")
}
