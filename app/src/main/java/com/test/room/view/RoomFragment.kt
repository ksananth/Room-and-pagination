package com.test.room.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import com.test.room.R
import com.test.room.ViewModelFactory
import com.test.room.adapter.ArticleAdapter
import com.test.room.db.Article
import com.test.room.viewmodel.ArticlesViewModel
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class RoomFragment() : Fragment(R.layout.fragment_list) {
    private lateinit var factory: ViewModelFactory
    private lateinit var viewModel: ArticlesViewModel
    private val adapter = ArticleAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        factory = ViewModelFactory(this, requireContext())
        viewModel = ViewModelProvider(this, factory)[ArticlesViewModel::class.java]
        viewModel.articles().observe(this, Observer { this.updateList(it) })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycleView.adapter = adapter
        viewModel.loadArticles()
    }

    private fun updateList(it: Flow<PagingData<Article>>) {
        lifecycleScope.launch {
            it.collectLatest { adapter.submitData(it) }
        }
    }
}