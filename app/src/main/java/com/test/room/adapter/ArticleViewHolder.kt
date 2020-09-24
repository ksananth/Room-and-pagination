package com.test.room.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.room.R
import com.test.room.db.Article

class ArticleViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
) {

    private val title = itemView.findViewById<TextView>(R.id.title)
    private val author = itemView.findViewById<TextView>(R.id.author)
    private val articleImage = itemView.findViewById<ImageView>(R.id.articleImage)
    var article: Article? = null

    fun bindTo(article: Article?) {
        this.article = article
        title.text = article?.title
        author.text = article?.author
        Glide.with(articleImage.context)
            .load(article?.urlToImage)
            .into(articleImage)
    }
}