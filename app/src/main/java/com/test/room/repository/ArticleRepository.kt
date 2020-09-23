package com.test.room.repository

import androidx.paging.PagingData
import com.test.room.db.Article
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {
    fun getArticles(): Flow<PagingData<Article>>
    fun clearArticles()
}