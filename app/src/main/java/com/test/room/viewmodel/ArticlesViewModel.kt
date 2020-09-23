package com.test.room.viewmodel

import androidx.lifecycle.ViewModel
import com.test.room.repository.RoomArticleRepository

class ArticlesViewModel(private val repository: RoomArticleRepository) : ViewModel() {

    val articles = repository.getArticles()
}