package com.test.room.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.test.room.R
import com.test.room.db.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SelectionViewModel(private val db: AppDatabase) : ViewModel() {
    init {
        viewModelScope.launch(IO) {
            db.userDao().nukeTable()
        }
    }

    fun roomDatabaseSelected(findNavController: NavController) {
        findNavController.navigate(R.id.action_selectionFragment_to_roomFragment)
    }

    fun apiSelected(findNavController: NavController) {
        findNavController.navigate(R.id.action_selectionFragment_to_apiFragment)
    }
}