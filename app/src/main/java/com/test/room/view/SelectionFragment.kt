package com.test.room.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.test.room.R
import com.test.room.model.SelectionViewModel
import kotlinx.android.synthetic.main.fragment_selection.*

class SelectionFragment : Fragment(R.layout.fragment_selection) {

    private val viewModel: SelectionViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button1.setOnClickListener {
            viewModel.roomDatabaseSelected(findNavController())
        }

        button2.setOnClickListener {
            viewModel.apiSelected(findNavController())
        }
    }
}