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
import com.mld.courskotlin.util.TestUtils
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_list_news.view.*

class ListNewsAdapter(private val listNews : List<News>) : RecyclerView.Adapter<ListNewsAdapter.ViewHolder>() {

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

    override fun onBindViewHolder(holder: ListNewsAdapter.ViewHolder, position: Int) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val info = listNews[holder.adapterPosition]
        holder.textView?.text = info.descLong

        val img = info.images?.get(0)
        img?.let {
            Picasso.get()
                .load(Uri.parse(it))
                .placeholder(R.drawable.placeholder)
                .into(holder.img)
        }
    }

    class ViewHolder(val root: View) : RecyclerView.ViewHolder(root){
        var img : ImageView? = null
        var textView : TextView? = null
        init {
            img = root.findViewById(R.id.imageView)
            textView = root.findViewById(R.id.textView)
        }
    }
}