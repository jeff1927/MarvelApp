package com.apps.marvelapp.presentation.fragments.heroes


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.apps.marvelapp.databinding.HeroesFragmentBinding
import com.apps.marvelapp.domain.constants.AN_ERROR_HAS_OCCURRED
import com.apps.marvelapp.domain.constants.GRID_LAYOUT_SPAN
import com.apps.marvelapp.domain.utils.Resource
import com.apps.marvelapp.domain.utils.hideProgressBar
import com.apps.marvelapp.domain.utils.showProgressBar
import com.apps.marvelapp.presentation.adapters.HeroesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeroesFragment : Fragment() {

    private val viewModel by viewModels<HeroesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = HeroesFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        HeroesFragmentBinding.bind(view).let { binding ->
            setupObserver(binding)
            setupListAdapter(binding)
        }
    }

    private fun setupListAdapter(binding: HeroesFragmentBinding) {
        binding.rvHeroes.apply {
            layoutManager = GridLayoutManager(requireContext(), GRID_LAYOUT_SPAN)
            adapter = HeroesAdapter()
        }
    }

    private fun setupObserver(binding: HeroesFragmentBinding) {
        viewModel.heroesList.observe(viewLifecycleOwner, Observer{ response ->
            when(response){
                is Resource.Loading -> {
                    binding.paginationProgressBar.showProgressBar()
                }
                is Resource.Success -> {
                    binding.paginationProgressBar.hideProgressBar()
                    binding.rvHeroes.adapter?.let{
                        response.data?.let { pagingData ->
                            (it as HeroesAdapter).submitData(lifecycle, pagingData )
                        }
                    }
                }
                is Resource.Error -> {
                    binding.paginationProgressBar.hideProgressBar()
                    response.message.let { message->
                        Toast.makeText(requireContext(),"$AN_ERROR_HAS_OCCURRED $message", Toast.LENGTH_LONG).show()
                    }
                }
            }
        })
    }
}