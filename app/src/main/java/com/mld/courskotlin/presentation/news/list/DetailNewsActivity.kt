package com.mld.courskotlin.presentation.news.list

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.mld.courskotlin.R
import com.mld.courskotlin.data.model.News
import com.mld.courskotlin.presentation.BaseActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_news_detail.*

class DetailNewsActivity : BaseActivity() {


    companion object {
        var argKey = "news"
        fun start(activity : BaseActivity, news: News) {
            val intent = Intent(activity, DetailNewsActivity::class.java)
            intent.putExtra(argKey, news)
            activity.startActivity(intent)
        }
    }

    override fun displayDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setTitle(title: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_news_detail)

        val news = intent.extras?.get(DetailNewsFragment.argKey) as News

        news.let {

            it.image?.let {image->
                Picasso.get()
                    .load(Uri.parse(image))
                    .placeholder(R.drawable.placeholder)
                    .into(img_detail)
            }

            //pour une liste
            it.images?.let { images ->
                Picasso.get()
                    .load(Uri.parse(images[0]))
                    .placeholder(R.drawable.placeholder)
                    .into(img_detail)
            }

            tv_title.text = it.title
            tv_description.text = it.descLong

        }
    }

}