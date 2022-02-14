package com.kemsu.pi_211.ui.second_group

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.kemsu.pi_211.R

class SecondGroupFragment : Fragment(R.layout.second_group_fragment) {
    private val viewModel: SecondGroupViewModel by viewModels()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }
}
