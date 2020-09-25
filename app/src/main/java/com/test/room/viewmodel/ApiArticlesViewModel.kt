package com.test.room.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.room.db.Article
import com.test.room.repository.ApiArticleRepository

class ApiArticlesViewModel(private val apiRepository: ApiArticleRepository) : ViewModel() {

    private val articles = MutableLiveData<List<Article>>()
    val progressBarVisibility = MutableLiveData<Int>()
    private val error = MutableLiveData<String>()

    suspend fun onViewCreated() {
        try {
            progressBarVisibility.postValue(View.VISIBLE)
            val response = apiRepository.getArticles()
            progressBarVisibility.postValue(View.GONE)
            articles.value = response
        } catch (e: Exception) {
            error.value = "Something went wrong!"
        }
    }


    fun getArticles() = articles
    fun error() = error
}