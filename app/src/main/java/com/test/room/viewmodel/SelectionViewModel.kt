package com.test.room.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.test.room.R
import com.test.room.db.AppDatabase

class SelectionViewModel(db: AppDatabase) : ViewModel() {
    init {
        db.userDao().nukeTable()
    }

    fun roomDatabaseSelected(findNavController: NavController) {
        findNavController.navigate(R.id.action_selectionFragment_to_roomFragment)

    }

    fun apiSelected(findNavController: NavController) {
        findNavController.navigate(R.id.action_selectionFragment_to_apiFragment)
    }
}