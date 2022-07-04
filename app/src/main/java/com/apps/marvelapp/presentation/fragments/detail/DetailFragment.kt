package com.apps.marvelapp.presentation.fragments.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.apps.marvelapp.R
import com.apps.marvelapp.base.BaseFragment
import com.apps.marvelapp.databinding.FragmentDetailBinding
import com.apps.marvelapp.domain.constants.HEROES_IMAGE_SIZE
import com.bumptech.glide.Glide

class DetailFragment : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {

    private val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
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