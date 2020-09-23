package com.test.room.repository

import com.test.room.domain.Article

interface ArticleRepository {
    fun getArticles():List<Article>
    fun clearArticles()
}