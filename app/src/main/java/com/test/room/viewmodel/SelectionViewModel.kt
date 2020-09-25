package com.test.room.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.test.room.R
import com.test.room.datastore.SettingsManager
import com.test.room.datastore.UiMode
import kotlinx.coroutines.launch

class SelectionViewModel(private val settingsManager: SettingsManager) : ViewModel() {


    fun roomDatabaseSelected(findNavController: NavController) {
        findNavController.navigate(R.id.action_selectionFragment_to_roomFragment)
    }

    fun apiSelected(findNavController: NavController) {
        findNavController.navigate(R.id.action_selectionFragment_to_apiFragment)
    }

    fun onThemeChanged(isChecked: Boolean) {
        val type = if (isChecked) UiMode.DARK else UiMode.LIGHT
        viewModelScope.launch {
            settingsManager.setUiMode(type)
        }
    }
}