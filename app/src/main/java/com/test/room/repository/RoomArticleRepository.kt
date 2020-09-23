package com.test.room.repository

import com.test.room.db.AppDatabase
import com.test.room.db.Article

class RoomArticleRepository(private val db: AppDatabase) : ArticleRepository {

    override fun getArticles(): List<Article> {
        return db.userDao().getAll()
    }

    override fun clearArticles() {
        db.userDao().nukeTable()
    }
}