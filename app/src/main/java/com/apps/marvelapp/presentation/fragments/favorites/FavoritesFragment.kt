package com.apps.marvelapp.presentation.fragments.favorites

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.apps.marvelapp.R
import com.apps.marvelapp.base.BaseFragment
import com.apps.marvelapp.databinding.FavoritesFragmentBinding

class FavoritesFragment : BaseFragment<FavoritesFragmentBinding>(FavoritesFragmentBinding::inflate) {

    private lateinit var viewModel: FavoritesViewModel

}