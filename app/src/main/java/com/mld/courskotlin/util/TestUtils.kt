package com.mld.courskotlin.util

import com.mld.courskotlin.data.model.News

object TestUtils {

    fun createNewsDataTest() : List<News> {
        val list = mutableListOf<News>()
        var news = News(0, "toto", "short", "long", null)
        list.add(news)

        val imgList = mutableListOf<String>()
        imgList.add("https://helpx.adobe.com/content/dam/help/en/stock/how-to/visual-reverse-image-search/_jcr_content/main-pars/image/visual-reverse-image-search-v2_1000x560.jpg")
        imgList.add("http://www.joomlack.fr/images/stories/images/on-top-of-earth.jpg")

        news = News(1, "titin", "short short", "longlong", imgList)
        list.add(news)

        news = News(2, "titin", "short short 2", "longlong 2")
        list.add(news)

        return list

    }
}