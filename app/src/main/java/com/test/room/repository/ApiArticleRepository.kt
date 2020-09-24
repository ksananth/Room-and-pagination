package com.test.room.repository

import com.test.room.api.ArticleApi
import com.test.room.db.Article

class ApiArticleRepository(private val api: ArticleApi) {

    suspend fun getArticles(): List<Article> {
        val articles = api.getArticles()
        return articles.articles
    }
}