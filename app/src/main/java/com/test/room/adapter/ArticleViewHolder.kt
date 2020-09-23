package com.test.room.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.test.room.R
import com.test.room.db.Article

class ArticleViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
) {

    private val title = itemView.findViewById<TextView>(R.id.title)
    var article: Article? = null

    fun bindTo(article: Article?) {
        this.article = article
        title.text = article?.title
    }
}