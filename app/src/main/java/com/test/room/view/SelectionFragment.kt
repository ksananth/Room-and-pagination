package com.test.room.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.navigation.fragment.findNavController
import com.test.room.R
import com.test.room.ViewModelFactory
import com.test.room.datastore.UiMode
import com.test.room.viewmodel.SelectionViewModel
import kotlinx.android.synthetic.main.fragment_selection.*

class SelectionFragment : Fragment(R.layout.fragment_selection) {

    private lateinit var factory: ViewModelFactory
    private lateinit var viewModel: SelectionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        factory = ViewModelFactory(this, requireContext())
        viewModel = ViewModelProvider(this, factory)[SelectionViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onViewCreated()
        viewModel.uiModeFlow.asLiveData().observe(viewLifecycleOwner, Observer {
            when (it) {
                UiMode.LIGHT -> onLightMode()
                UiMode.DARK -> onDarkMode()
            }
        })
        button1.setOnClickListener {
            viewModel.roomDatabaseSelected(findNavController())
        }

        button2.setOnClickListener {
            viewModel.apiSelected(findNavController())
        }

        themeMode.setOnCheckedChangeListener { _, isChecked ->
            viewModel.onThemeChanged(isChecked)
        }
    }

    private fun onDarkMode() {
        themeMode.isChecked = true
    }

    private fun onLightMode() {
        themeMode.isChecked = false
    }
}