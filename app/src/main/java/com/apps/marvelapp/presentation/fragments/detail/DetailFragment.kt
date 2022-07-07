package com.apps.marvelapp.presentation.fragments.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.apps.marvelapp.base.BaseFragment
import com.apps.marvelapp.databinding.FragmentDetailBinding
import com.apps.marvelapp.domain.constants.HEROES_IMAGE_SIZE
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {

    private val args: DetailFragmentArgs by navArgs()

    private val viewModel by viewModels<DetailViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupListeners()
    }

    private fun setupListeners() {
        val character = args.character
        binding.fabAddToFavorites.setOnClickListener {
            viewModel.addCharacterToFavorites(character)
        }
    }

    private fun setupView() {
        val character = args.character
        with(binding){
            tvCharacterName.text = character.name
            tvDescription.text = character.bio
            Glide.with(this.root).load(character.imagePath + HEROES_IMAGE_SIZE + character.imageExt).into(ivCharacter)
        }
    }
}