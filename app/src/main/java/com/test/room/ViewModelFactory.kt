package com.test.room

import android.content.Context
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.test.room.db.AppDatabase
import com.test.room.viewmodel.ArticlesViewModel
import com.test.room.viewmodel.SelectionViewModel

class ViewModelFactory(
    private val owner: SavedStateRegistryOwner,
    private val context: Context
) : AbstractSavedStateViewModelFactory(owner, null) {

    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        val db = AppDatabase.create(context, false)
        return when (modelClass) {
            ArticlesViewModel::class.java -> ArticlesViewModel(db)
            SelectionViewModel::class.java -> SelectionViewModel(db)
            else -> throw IllegalArgumentException("ViewModel Not Found")
        } as T
    }
}