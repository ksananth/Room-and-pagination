package com.test.room.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.test.room.R
import com.test.room.ViewModelFactory
import com.test.room.adapter.ApiArticleAdapter
import com.test.room.db.Article
import com.test.room.viewmodel.ApiArticlesViewModel
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.coroutines.launch

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
        viewModel.getArticles().observe(viewLifecycleOwner, Observer { this.updateList(it) })
        viewModel.error().observe(viewLifecycleOwner, Observer { this.showError(it) })
        viewModel.progressBarVisibility.observe(viewLifecycleOwner, Observer {
            progressBar.visibility = it
        })

        lifecycleScope.launch {
            viewModel.onViewCreated()
        }
    }

    private fun showError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    private fun updateList(list: List<Article>) {
        adapter.updateList(list)
    }
}