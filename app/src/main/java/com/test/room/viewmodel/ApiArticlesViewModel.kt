package com.test.room.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.room.db.Article
import com.test.room.repository.ApiArticleRepository
import kotlinx.coroutines.delay

class ApiArticlesViewModel(private val apiRepository: ApiArticleRepository) : ViewModel() {

    private val articles = MutableLiveData<List<Article>>()
    val progressBarVisibility = MutableLiveData<Int>()

    suspend fun onViewCreated() {
        progressBarVisibility.postValue(View.VISIBLE)
        delay(3000)
        val response = apiRepository.getArticles()

        progressBarVisibility.postValue(View.GONE)

        articles.value = response
    }

    fun getArticles() = articles
}