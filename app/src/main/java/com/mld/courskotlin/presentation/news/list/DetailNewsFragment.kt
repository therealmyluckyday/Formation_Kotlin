package com.mld.courskotlin.presentation.news.list

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mld.courskotlin.R
import com.mld.courskotlin.data.model.News
import com.mld.courskotlin.presentation.BaseFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_news_detail.*

class DetailNewsFragment : BaseFragment() {

    companion object {
        var argKey = "news"
        fun newInstance(news: News): DetailNewsFragment {
            return DetailNewsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(argKey, news)
                }
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_news_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val news = arguments?.get(argKey) as News

        news.let {

            it.image?.let { image ->
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