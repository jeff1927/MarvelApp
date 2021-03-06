package com.apps.marvelapp.presentation.fragments.comics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.apps.marvelapp.base.BaseFragment
import com.apps.marvelapp.databinding.ComicsFragmentBinding
import com.apps.marvelapp.presentation.adapters.ComicsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComicsFragment : BaseFragment<ComicsFragmentBinding> (ComicsFragmentBinding::inflate) {

    private val  viewModel by viewModels<ComicsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            setupObserver()
            setupPageListAdapter()
    }

    private fun setupPageListAdapter() {
        binding.rvComics.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ComicsAdapter()
        }
    }

    private fun setupObserver() {
        viewModel.comicsList.observe(viewLifecycleOwner, Observer{ response ->
            binding.rvComics.adapter.let { adapter->
                response.data?.let {
                    (adapter as ComicsAdapter).submitData(lifecycle,it)
                }
            }
        })
    }
}