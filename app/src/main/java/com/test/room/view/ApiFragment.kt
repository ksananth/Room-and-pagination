package com.test.room.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.test.room.R
import com.test.room.ViewModelFactory
import com.test.room.adapter.ApiArticleAdapter
import com.test.room.viewmodel.ApiArticlesViewModel
import kotlinx.android.synthetic.main.fragment_list.*

class ApiFragment : Fragment(R.layout.fragment_list) {
    private lateinit var factory: ViewModelFactory
    private lateinit var viewModel: ApiArticlesViewModel
    private lateinit var adapter: ApiArticleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        factory = ViewModelFactory(this, requireContext())
        viewModel = ViewModelProvider(this, factory)[ApiArticlesViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ApiArticleAdapter()
        articleRecycleView.adapter = adapter
    }
}