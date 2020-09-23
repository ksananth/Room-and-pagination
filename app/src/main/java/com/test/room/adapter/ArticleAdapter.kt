package com.test.room.adapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.test.room.db.Article

class ArticleAdapter : PagingDataAdapter<Article, ArticleViewHolder>(diffCallback) {

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder =
        ArticleViewHolder(parent)

    companion object {

        private val diffCallback = object : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean =
                oldItem.uid == newItem.uid

            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean =
                oldItem == newItem
        }
    }
}