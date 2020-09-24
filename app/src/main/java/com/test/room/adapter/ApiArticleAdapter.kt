package com.test.room.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.room.db.Article

class ApiArticleAdapter(private var list: List<Article> = emptyList()) :
    RecyclerView.Adapter<ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder =
        ArticleViewHolder(parent)

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bindTo(list[position])
    }

    fun updateList(updatedList: List<Article>) {
        list =updatedList
        notifyDataSetChanged()
    }
}