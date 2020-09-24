package com.test.room.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.room.R
import com.test.room.ViewModelFactory
import com.test.room.adapter.ArticleAdapter
import com.test.room.viewmodel.ArticlesViewModel
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class RoomFragment() : Fragment(R.layout.fragment_list) {
    private lateinit var factory: ViewModelFactory
    private lateinit var viewModel: ArticlesViewModel
    private lateinit var adapter: ArticleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        factory = ViewModelFactory(this, requireContext())
        viewModel = ViewModelProvider(this, factory)[ArticlesViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ArticleAdapter()
        articleList.adapter = adapter
        articleList.layoutManager = LinearLayoutManager(context)
        lifecycleScope.launch {
            viewModel.articles.collectLatest { adapter.submitData(it) }
        }
    }
}