package com.test.room.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.test.room.db.Article
import com.test.room.repository.RoomArticleRepository
import kotlinx.coroutines.flow.Flow

class ArticlesViewModel(private val repository: RoomArticleRepository) : ViewModel() {

    private val articles = MutableLiveData<Flow<PagingData<Article>>>()

    fun loadArticles() {
        val response = repository.getArticles()
        articles.value = response
    }

    fun articles() = articles
}