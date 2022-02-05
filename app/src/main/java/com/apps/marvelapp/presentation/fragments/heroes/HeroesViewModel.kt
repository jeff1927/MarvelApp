package com.apps.marvelapp.presentation.fragments.heroes


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apps.marvelapp.domain.models.HeroModel
import com.apps.marvelapp.domain.usecase.GetHeroesListUseCase
import com.apps.marvelapp.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class HeroesViewModel @Inject constructor(private val getHeroesListUseCase: GetHeroesListUseCase) : ViewModel() {

    private val _heroesList = MutableLiveData<Resource<List<HeroModel>>>()
    val heroesList: LiveData<Resource<List<HeroModel>>> = _heroesList

    init {
        getHeroesList()
    }

    private fun getHeroesList() = viewModelScope.launch {
        _heroesList.postValue(Resource.Loading())
        try{
            val response = getHeroesListUseCase.getHeroesList()
            _heroesList.postValue(Resource.Success(response))
        }catch (t:Throwable){
            when(t){
                is IOException -> _heroesList.postValue(Resource.Error("network failure"))
                else -> _heroesList.postValue(Resource.Error("conversion error"))
            }
        }
    }

}