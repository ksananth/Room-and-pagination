package com.test.room.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.test.room.db.Article
import com.test.room.repository.RoomArticleRepository
import kotlinx.coroutines.flow.Flow

class ArticlesViewModel(repository: RoomArticleRepository) : ViewModel() {

    val articles: Flow<PagingData<Article>> = repository.getArticles()
}