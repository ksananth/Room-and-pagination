package com.test.room.repository

import com.test.room.db.AppDatabase
import com.test.room.domain.Article

class RoomArticleRepository(private val db: AppDatabase) : ArticleRepository {

    override fun getArticles(): List<Article> {
        TODO("Not yet implemented")
    }

    override fun clearArticles() {
        db.userDao().nukeTable()
    }
}