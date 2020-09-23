package com.test.room.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.test.room.db.AppDatabase
import com.test.room.db.Article
import kotlinx.coroutines.flow.Flow

class RoomArticleRepository(private val db: AppDatabase) : ArticleRepository {

    override fun getArticles(): Flow<PagingData<Article>> =
        Pager(config = PagingConfig(pageSize, enablePlaceholders = true, maxSize = maxSize)) {
            db.userDao().getAll()
        }.flow

    override fun clearArticles() {
        db.userDao().nukeTable()
    }

    companion object {
        const val pageSize = 50
        const val maxSize = 200
    }
}