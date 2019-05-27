package com.mld.courskotlin.presentation.news.list

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mld.courskotlin.R
import com.mld.courskotlin.data.model.News
import com.squareup.picasso.Picasso

class ListNewsAdapter(
    private var listNews: List<News>,
    private var listener: (position: Int, news: News) -> Unit
) : RecyclerView.Adapter<ListNewsAdapter.ViewHolder>() {

    fun updateList(list: List<News>) {
        listNews = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListNewsAdapter.ViewHolder {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_list_news, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        return listNews.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val info = listNews[holder.adapterPosition]
        holder.title?.text = info.title
        holder.desc?.text = info.descShort

        val img = info.image
        img?.let {
            Picasso.get()
                .load(Uri.parse(it))
                .placeholder(R.drawable.placeholder)
                .into(holder.img)
        }

        holder.img?.setOnClickListener {
            listener(holder.adapterPosition, info)
        }

    }

    class ViewHolder(root: View) : RecyclerView.ViewHolder(root) {
        var img: ImageView? = null
        var title: TextView? = null
        var desc: TextView? = null

        init {
            img = root.findViewById(R.id.imageView)
            title = root.findViewById(R.id.title)
            desc = root.findViewById(R.id.desc_short)
        }
    }
}