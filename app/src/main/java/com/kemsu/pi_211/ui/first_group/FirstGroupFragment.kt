package com.kemsu.pi_211.ui.first_group

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kemsu.pi_211.R
import com.kemsu.pi_211.databinding.FirstGroupFragmentBinding
import timber.log.Timber

class FirstGroupFragment : Fragment(R.layout.first_group_fragment) {
    private val viewModel: FirstGroupViewModel by viewModels()
    private val binding by viewBinding(FirstGroupFragmentBinding::bind)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.currentDay.observe(viewLifecycleOwner) {
            Timber.tag("TAGGG").d(it.toString())
        }
    }
}
