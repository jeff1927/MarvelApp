package com.apps.marvelapp.presentation.fragments.comics

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.apps.marvelapp.R

class ComicsFragment : Fragment() {

    private lateinit var viewModel: ComicsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.comics_fragment, container, false)
    }
}