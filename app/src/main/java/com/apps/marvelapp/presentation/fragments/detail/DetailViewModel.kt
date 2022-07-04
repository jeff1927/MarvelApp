package com.apps.marvelapp.presentation.fragments.detail

import androidx.lifecycle.ViewModel
import com.apps.marvelapp.domain.models.CharacterModel
import com.apps.marvelapp.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(): ViewModel(){

    fun addCharacterToFavorites(character: CharacterModel) {

    }
}