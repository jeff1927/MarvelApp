package com.apps.marvelapp.domain.usecase

import com.apps.marvelapp.domain.models.CharacterModel
import com.apps.marvelapp.domain.repository.CharactersRepository
import javax.inject.Inject

class AddCharacterToFavoritesUseCase @Inject constructor(private val charactersRepository: CharactersRepository) {
    suspend operator fun invoke(character: CharacterModel){
        charactersRepository.saveCharacter(character)
    }
}