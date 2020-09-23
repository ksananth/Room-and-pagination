package com.test.room.repository

import com.test.room.db.Article

interface ArticleRepository {
    fun getArticles(): List<Article>
    fun clearArticles()
}