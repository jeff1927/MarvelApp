package com.apps.marvelapp.presentation.fragments.heroes

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.apps.marvelapp.R

class HeroesFragment : Fragment() {

    private lateinit var viewModel: HeroesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.heroes_fragment, container, false)
    }
}