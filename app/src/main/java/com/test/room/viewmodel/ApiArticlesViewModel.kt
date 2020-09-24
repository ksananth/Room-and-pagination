package com.test.room.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.room.db.Article
import com.test.room.repository.ApiArticleRepository

class ApiArticlesViewModel(private val apiRepository: ApiArticleRepository) : ViewModel() {

    private val articles = MutableLiveData<List<Article>>()

    suspend fun onViewCreated() {
        val response = apiRepository.getArticles()
        articles.value = response
    }

    fun getArticles() = articles
}