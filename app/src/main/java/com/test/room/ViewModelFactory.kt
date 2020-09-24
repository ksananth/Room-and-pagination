package com.test.room

import android.content.Context
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.test.room.api.ArticleApi
import com.test.room.db.AppDatabase
import com.test.room.repository.ApiArticleRepository
import com.test.room.repository.RoomArticleRepository
import com.test.room.viewmodel.ArticlesViewModel
import com.test.room.viewmodel.ApiArticlesViewModel
import com.test.room.viewmodel.SelectionViewModel

class ViewModelFactory(
    owner: SavedStateRegistryOwner,
    private val context: Context
) : AbstractSavedStateViewModelFactory(owner, null) {

    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        val db by lazy { AppDatabase.create(context) }
        val api by lazy { ArticleApi.create() }

        val roomRepository = RoomArticleRepository(db)
        val apiRepository = ApiArticleRepository(api)

        return when (modelClass) {
            ArticlesViewModel::class.java -> ArticlesViewModel(roomRepository)
            ApiArticlesViewModel::class.java -> ApiArticlesViewModel(apiRepository)
            SelectionViewModel::class.java -> SelectionViewModel()
            else -> throw IllegalArgumentException("ViewModel Not Found")
        } as T
    }
}