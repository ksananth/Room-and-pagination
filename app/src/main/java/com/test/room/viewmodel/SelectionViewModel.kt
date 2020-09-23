package com.test.room.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.test.room.R
import com.test.room.repository.ArticleRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class SelectionViewModel(private val repository: ArticleRepository) : ViewModel() {

    init {
        viewModelScope.launch(IO) {
            repository.clearArticles()
        }
    }

    fun roomDatabaseSelected(findNavController: NavController) {
        findNavController.navigate(R.id.action_selectionFragment_to_roomFragment)
    }

    fun apiSelected(findNavController: NavController) {
        findNavController.navigate(R.id.action_selectionFragment_to_apiFragment)
    }
}