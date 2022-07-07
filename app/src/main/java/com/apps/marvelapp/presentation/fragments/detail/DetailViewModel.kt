package com.apps.marvelapp.presentation.fragments.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apps.marvelapp.domain.models.CharacterModel
import com.apps.marvelapp.domain.usecase.AddCharacterToFavoritesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val addCharacterToFavoritesUseCase: AddCharacterToFavoritesUseCase
    ): ViewModel() {

    fun addCharacterToFavorites(character: CharacterModel) {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                addCharacterToFavoritesUseCase(character)
            }
        }
    }
}